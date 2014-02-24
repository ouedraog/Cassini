
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
package org.insa.controller.validator;

import org.insa.view.form.FormPanel;

/**
 *
 * @author Thomas Thiebaud
 */
public abstract class FormValidator {
    
    protected FormPanel formPanel = null;
    
    protected String error = "";
    protected String success = "";
    
    /**
     * Constructor
     * @param formPanel Form which need to be validated
     */
    public FormValidator(FormPanel formPanel) {
        this.formPanel = formPanel;
    }
    
    /**
     * Methode for form validation
     * @return true if form is correct, false otherwise
     */
    public abstract boolean validate();
    
    /**
     * Get error message
     * @return Error message
     */
    public String getError() {
        return error;
    }
    
    /**
     * Get success message
     * @return Success message
     */
    public String getSuccess() {
        return success;
    }
}