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
package org.insa.model.items;

import java.util.ArrayList;
import org.insa.core.driving.Vehicle;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Abel Juste Ouedraogo, Guillaume Garzone, François Aïssaoui, Thomas Thiebaud
 * Class VehiclesModel
 * Uses Simple framework for xml serialization.
 * See http://simple.sourceforge.net/ for further details.
 */
@Root
public class VehiclesModel {
    /**
     * vehicles
     */
    @ElementList
    private ArrayList<Vehicle> vehicles;
    
    /**
     * Constructor
     */
    public VehiclesModel(){
        this.vehicles = new ArrayList<>();
    }
    
    /**
     * Clear the vehicles model
     */
    public void clear() {
        vehicles.clear();
    }
    
    /**
     * Get vehicle number
     * @return Number of vehicles
     */
    public int getVehicleNumber() {
        return vehicles.size();
    }
    
    /**
     * Add a vehicle
     * @param v Vehicle to add
     */
    public void addVehicle(Vehicle v){
        this.vehicles.add(v);
    }
    
    /**
     * remove a vehicle
     * @param v Vehicle to remove
     * @return Vehicles model
     */
    public VehiclesModel removeVehicle(Vehicle v){
        this.vehicles.remove(v);
        return this;
    }
    
    /**
     * Get vehicles
     * @return Vehicles 
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    
    /**
     * Set vehicles
     * @param vehicles New vehicles list 
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        String s = "";
        for(Vehicle v : vehicles) {
            s += v.toString() + "\n";
        }
        return s;
    }
}
