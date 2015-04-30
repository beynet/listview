package org.beynet.listview;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Created by beynet on 29/04/2015.
 */
public class PersonCell extends ListCell<Person> {
    @Override
    protected void updateItem(Person item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);
        if (item!=null && empty==false) {
            HBox content = new HBox();
            Label firstName = new Label(item.getFirstName()+" ");
            firstName.setTextFill(Color.RED);
            Label name = new Label(item.getLastName());
            name.setTextFill(Color.BLUE);
            content.getChildren().addAll(firstName,name);
            setGraphic(content);
        }
    }
}
