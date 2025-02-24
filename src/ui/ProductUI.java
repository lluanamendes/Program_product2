package ui;

import entities.ImportedProduct;
import entities.Product;
import entities.Usedproduct;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductUI extends Application {
    private List<Product> productList = new ArrayList<>();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Produtos");

        // Labels e campos de entrada
        Label nameLabel = new Label("Nome do Produto:");
        TextField nameField = new TextField();

        Label priceLabel = new Label("Preço:");
        TextField priceField = new TextField();

        Label typeLabel = new Label("Tipo do Produto:");
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Comum", "Usado", "Importado");
        typeComboBox.setValue("Comum");

        Label extraLabel = new Label("Data de Fabricação (Usado) / Taxa Alfandegária (Importado):");
        TextField extraField = new TextField();
        extraField.setDisable(true);

        // Atualiza campo extra dependendo do tipo escolhido
        typeComboBox.setOnAction(e -> {
            String selectedType = typeComboBox.getValue();
            if (selectedType.equals("Usado")) {
                extraLabel.setText("Data de Fabricação (DD/MM/YYYY):");
                extraField.setDisable(false);
            } else if (selectedType.equals("Importado")) {
                extraLabel.setText("Taxa Alfandegária:");
                extraField.setDisable(false);
            } else {
                extraField.setDisable(true);
            }
        });

        // Botão para adicionar produto
        Button addButton = new Button("Adicionar Produto");
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String type = typeComboBox.getValue();

                Product product = null;

                if (type.equals("Usado")) {
                    LocalDate manufactureDate = LocalDate.parse(extraField.getText(), fmt);
                    product = new Usedproduct(name, price, manufactureDate);
                } else if (type.equals("Importado")) {
                    double customsFee = Double.parseDouble(extraField.getText());
                    product = new ImportedProduct(name, price, customsFee);
                } else {
                    product = new Product(name, price);
                }

                productList.add(product);
                updateOutput();
                clearFields(nameField, priceField, extraField);
            } catch (Exception ex) {
                showAlert("Erro", "Entrada inválida. Verifique os valores e tente novamente.");
            }
        });

        // Layout da interface
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                nameLabel, nameField,
                priceLabel, priceField,
                typeLabel, typeComboBox,
                extraLabel, extraField,
                addButton,
                new Label("Produtos Cadastrados:"),
                outputArea
        );

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Atualiza a lista de produtos na interface
    private void updateOutput() {
        StringBuilder sb = new StringBuilder();
        for (Product p : productList) {
            sb.append(p.priceTag()).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    // Limpa os campos após adicionar um produto
    private void clearFields(TextField name, TextField price, TextField extra) {
        name.clear();
        price.clear();
        extra.clear();
    }

    // Exibe um alerta de erro
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Método para iniciar a aplicação
    public static void launchApp() {
        launch(); // Inicia a aplicação JavaFX
    }
}
