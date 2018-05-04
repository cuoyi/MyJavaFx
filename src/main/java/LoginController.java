package main.java;

import com.sun.deploy.util.StringUtils;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class LoginController extends BaseFXController {

    @FXML
    private ListView<String> listView;

    @FXML
    private WebView webView;

    private LoginController controller;

    public LoginController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> names = observableArrayList("baidu2", "zhihu", "qq", "126");
        listView.setItems(names);

        Callback<ListView<String>, ListCell<String>> defaultCellFactory = TextFieldListCell.forListView();
        listView.setCellFactory((ListView<String> tv) -> {
            ListCell<String> cell = defaultCellFactory.call(tv);
            cell.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (null != cell.getText() && !"".equals(cell.getText())) {
                    System.out.println(cell.getText());
                    WebView browser = new WebView();
                    WebEngine webEngine = browser.getEngine();
                    String url = "http://" + cell.getText() + ".com";
                    System.out.println(url);
                    webEngine.load(url);
                }
            });
            return cell;
        });

    }

}
