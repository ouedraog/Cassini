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
package org.insa.controller;

import java.util.Timer;
import org.insa.controller.task.SimulationTask;
import org.insa.model.Model;

/**
 *
 * @author Juste Abel Oueadraogo & Guillaume Garzone & François Aïssaoui &   Thomas Thiebaud
 * Class SimulationController
 * Manage trafic : priority, trafic lights, and vehicle movement
 */
public class SimulationController {
    
    /**
     * simulation step (in ms)
     */
    private int simulationStep;
    
    /**
     * simulation timer in charge of traffic update
     */
    Timer timer;
    
    /**
     * constructor
     * @param step
     */
    public SimulationController(int step) {
        super();
        this.simulationStep = step;
    }
     
    /**
     *start simulation
     */
    public void start(){
        Model model = MainController.getInstance().getModel();
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new SimulationTask(model),0, simulationStep);
    }
    
    /**
     * pause simulation
     */
    public void pause(){
        this.timer.cancel();
    }
     
    /**
     *resume simulation
     */
    public void resume(){
        this.start();
    }
    /**
     * stop simulation
     */
    public void stop(){
        timer.cancel();
        timer.purge();
    }
    
    
    /*
    * getters and setters
    */
    public void setSimulationStep(int simulationStep) {
        this.simulationStep = simulationStep;
    }
    
    public int getSimulationStep() {
        return simulationStep;
    }
    
    
}