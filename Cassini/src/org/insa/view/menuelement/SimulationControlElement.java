/*
 * Copyright 2014 Abel Juste Oueadraogo & Guillaume Garzone & François Aïssaoui & Thomas Thiebaud
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
package org.insa.view.menuelement;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.insa.controller.MainController;

/**
 *
 * @author Thomas Thiebaud
 */
public class SimulationControlElement extends MenuElement{

    private String imageName = "default";
    
    /**
     * Constructor
     * @param imageName Name of the picture located in org.insa.view.image package 
     */
    public SimulationControlElement(String imageName) {
        super("",40,40,Font.font("Arial", FontWeight.BLACK, 15));
        this.imageName = imageName;

        this.setGraphic(new ImageView(new Image("/org/insa/view/image/" + imageName + ".png")));
        this.setAlignment(Pos.CENTER);
    }
    
    @Override
    public void performAddAction() {
        switch(imageName) {
            case "play" :
                MainController.getInstance().performPlaySimulation();
                break;
            case "pause" : 
                MainController.getInstance().performPauseSimulation();
                break;
            case "stop" :
                MainController.getInstance().performStopSimulation();
                break;
            case "rewind" :
                MainController.getInstance().performBackwardSimulation();
                break;
            case "forward" :
                MainController.getInstance().performForwardSimulation();
                break;
        }
    }
    
}
