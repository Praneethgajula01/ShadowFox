package src;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InventoryManagementSystem extends Application {

    private ObservableList<String> inventoryItems = FXCollections.observableArrayList();
    private ListView<String> inventoryListView = new ListView<>(inventoryItems);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        // Create UI components
        Label nameLabel = new Label("Item Name:");
        TextField nameField = new TextField();
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(addButton, 2, 0);
        grid.add(updateButton, 3, 0);
        grid.add(deleteButton, 4, 0);
        grid.add(inventoryListView, 0, 1, 5, 1);

        // Event Handlers
        addButton.setOnAction(e -> {
            String itemName = nameField.getText().trim();
            if (!itemName.isEmpty()) {
                inventoryItems.add(itemName);
                nameField.clear();
            }
        });

        updateButton.setOnAction(e -> {
            String selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
            String newName = nameField.getText().trim();
            if (selectedItem != null && !newName.isEmpty()) {
                int selectedIndex = inventoryListView.getSelectionModel().getSelectedIndex();
                inventoryItems.set(selectedIndex, newName);
                nameField.clear();
            }
        });

        deleteButton.setOnAction(e -> {
            String selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                inventoryItems.remove(selectedItem);
            }
        });

        // Set Scene
        Scene scene = new Scene(grid, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}