/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gn.decorator.component;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/10/2018
 * Version 1.0
 */
public abstract class GNControl extends HBox implements ComponentBase {

    private StringProperty text;
    private String subtitle;

    public GNControl(String text, String subtitle) {

        this.text = new SimpleStringProperty(text);
        this.subtitle = subtitle;

        this.setAlignment(Pos.CENTER);
        if(createAction() != null){
            if(createIcon() != null && createStatus() != null) {
                this.getChildren().addAll(createIcon(), createAction(), createStatus());
            } else if (createIcon() != null){
                this.getChildren().addAll(createIcon(), createAction());
            } else if(createStatus() != null){
                this.getChildren().addAll( createStatus(), createAction());
            } else {
                this.getChildren().add(createAction());
            }
        } else {
            System.err.println("Decorator Error : No component action for item");
        }
    }

    @Override
    public Node createIcon() {
        return icon();
    }

    @Override
    public Node createAction() {
        return action();
    }

    @Override
    public Node createStatus() {
        return status();
    }

    public String getText() {
        return this.text.get();
    }

    public StringProperty textProperty(){
        return text;
    }

    public void setText(String text){
        this.text.set(text);
    }

    public String getSubtitle(){
        return subtitle;
    }

    public abstract Node icon();
    public abstract Node status();
    public abstract Node action();

}