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

package org.insa.view.panel;

import org.insa.view.menu.MainMenu;
import javafx.scene.layout.BorderPane;
import org.insa.controller.MainController;
/**
 *
 * @author Thomas Thiebaud
 */
public class MainPanel extends BorderPane{
    
    private final BorderPane layout = new BorderPane();
    private final MainMenu mainMenu = new MainMenu();
    private final DefaultPanel defaultPanel = new DefaultPanel();
    
    /**
     * Default constructor
     */
    public MainPanel() {
        MainController.getInstance().setMainPanel(this);
        
        layout.setLeft(new TitlePanel());
        layout.setCenter(mainMenu);
        
        this.setLeft(layout);
        this.setCenter(defaultPanel);
    }
}