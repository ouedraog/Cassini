/*
* Copyright 2014 Juste Abel Ouedraogo, Guillaume Garzone, François Aïssaoui, Thomas Thiebaud
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.insa.view.form;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import org.insa.controller.MainController;
import org.insa.controller.validator.VehiclesValidator;
import org.insa.core.driving.Vehicle;
import org.insa.mission.Mission;
import org.insa.mission.PathNotFoundException;
import org.insa.view.graphicmodel.GraphicNode;
import org.insa.view.graphicmodel.GraphicSection;


/**
 *
 * @author Thomas Thiebaud
 */
public class VehiclesForm extends FormPanel {
    
    private final TextField maxSpeed = new TextField();
    private final TextField maxAcceleration = new TextField();
    private final TextField maxDeceleration = new TextField();
    private final TextField length = new TextField();
    private final TextField quantity = new TextField("1");
    private final MissionPicker mission = new MissionPicker();
    private final SubmitButton submit = new SubmitButton("Ajouter", this);
    
    /**
     * Default constructor
     */
    public VehiclesForm() {
        this.formValidator = new VehiclesValidator(this);
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);
        
        this.addFormField(new FormField("Vitesse maximale", maxSpeed));
        this.addFormField(new FormField("Accélération maximale", maxAcceleration));
        this.addFormField(new FormField("Décélération maximale", maxDeceleration));
        this.addFormField(new FormField("Longueur", length));
        this.addFormField(new FormField("Quantité", quantity));
        this.addFormField(new FormField("Mission", mission));
        this.addFormField(new FormField("", submit));
        
        this.setPadding(new Insets(10));
    }
    
    @Override
    public void performSubmitAction() {
        if(formValidator.validate()) {
            
            int maxSpeedValue = Integer.valueOf(maxSpeed.getText());
            int maxAccelerationValue = Integer.valueOf(maxAcceleration.getText());
            int maxDecelerationValue = Integer.valueOf(maxDeceleration.getText());
            int lengthValue = Integer.valueOf(length.getText());
            Mission missionValue = null;
            
            for(int i=0; i< Integer.valueOf(quantity.getText()).intValue(); i++) {
                Vehicle vehicle = new Vehicle();
                vehicle.setMaxSpeed(maxSpeedValue);
                vehicle.setMaxAcceleration(maxAccelerationValue);
                vehicle.setMaxDeceleration(maxDecelerationValue);
                vehicle.setLength(lengthValue);
                
                try {
                    GraphicNode sourceNode = mission.getSourceNodePicker().getNode().getGraphicNode();
                    GraphicNode targetNode = mission.getTargetNodePicker().getNode().getGraphicNode();
                    GraphicSection sourceSection = null;
                    GraphicSection targetSection = null;
                    for(GraphicSection s : mission.getSourceNodePicker().getNode().getGraphicNode().getGraphicSections()) {
                        if(s.getSourceNode().equals(sourceNode)) {
                            sourceSection = s;
                            break;
                        }
                    }
                    for(GraphicSection s : mission.getTargetNodePicker().getNode().getGraphicNode().getGraphicSections()) {
                        if(s.getTargetNode().equals(targetNode)) {
                            targetSection = s;
                            break;
                        }
                    }
                    missionValue = new Mission(sourceSection.getSection(), targetSection.getSection());
                } catch (PathNotFoundException ex) {
                    informationLabel.setText("Les points choisis pour la mission ne sont pas joignables");
                    Logger.getLogger(VehiclesForm.class.getName()).log(Level.SEVERE, "mission non réalisable", "Mission non réalisable");
                } catch (NullPointerException ex) {
                    //Easy way to allow a null mission
                    //ex.printStackTrace();
                    Logger.getLogger(VehiclesForm.class.getName()).log(Level.SEVERE, ex.toString());
                }
                
                vehicle.setMission(missionValue);
                MainController.getInstance().performAddVehicle(vehicle);
            }
            
            informationLabel.setText(formValidator.getSuccess());
        } else {
            informationLabel.setText(formValidator.getError());
        }
    }
    
    /**
     * Get max speed field
     * @return Max speed field
     */
    public TextField getMaxSpeed() {
        return maxSpeed;
    }
    
    /**
     * Get max acceleration field
     * @return Max acceleration field
     */
    public TextField getMaxAcceleration() {
        return maxAcceleration;
    }
    
    /**
     * Get max deceleration field
     * @return Max deceleration field
     */
    public TextField getMaxDeceleration() {
        return maxDeceleration;
    }
    
    /**
     * Get vehicle length
     * @return Vehicle length
     */
    public TextField getLength() {
        return length;
    }
    
    /**
     * Get vehicle quantity
     * @return Vehicle quantity
     */
    public TextField getQuantity() {
        return quantity;
    }
}
