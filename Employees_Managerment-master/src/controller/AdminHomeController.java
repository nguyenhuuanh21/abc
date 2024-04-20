package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdminHomeController implements Initializable{
	private Stage stage;
	private AnchorPane root;
	private Scene scene;


    @FXML
    private Button menu_add;

    @FXML
    private Button menu_calendar;

    @FXML
    private Button menu_delete;

    @FXML
    private Button menu_department;

    @FXML
    private Button menu_edit;

    @FXML
    private Button menu_home;

    @FXML
    private Button menu_logout;

    @FXML
    private Button menu_setting;

    @FXML
    private Button menu_work;

    @FXML
    private LineChart<?, ?> myLineChart;

    @FXML
    private PieChart myPieChart;

    
    private void inLineChart() {
    	XYChart.Series series = new XYChart.Series();
    	series.getData().add(new XYChart.Data("Mon",8));
    	series.getData().add(new XYChart.Data("Tue",12));
    	series.getData().add(new XYChart.Data("Wed",10));
    	series.getData().add(new XYChart.Data("Thu",15));
    	series.getData().add(new XYChart.Data("Fri",12));
    	series.getData().add(new XYChart.Data("Sat",8));
    	series.getData().add(new XYChart.Data("Sun",5));
    	myLineChart.getData().addAll(series);
    	myLineChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent;");
    	series.getNode().setStyle("-fx-stroke:gray");
    }
    
    public void logout(ActionEvent event)throws IOException {
    	 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Logout");
         alert.setContentText("Do you want to logout?");
         alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
         alert.showAndWait().ifPresent(response -> {
             if (response == ButtonType.OK) {
            	 stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                 try {
					root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
             }
         });
    	
    	
    	
    }
    
    private void inPieChart() {
		ObservableList<PieChart.Data> pieCharData = FXCollections.observableArrayList(
				new PieChart.Data("1",20),
				new PieChart.Data("2",5),
				new PieChart.Data("3",15),
				new PieChart.Data("4",35),
				new PieChart.Data("5",25)
				);
		myPieChart.setData(pieCharData);
	}
    

 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		inLineChart();
		inPieChart();
	}
}
