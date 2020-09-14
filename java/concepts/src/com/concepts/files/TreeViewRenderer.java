package com.concepts.files;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewRenderer extends Application {

	static com.concepts.files.Node node;

	public static void main(String[] args) {
		DirectoryReader directoryReader = new DirectoryReader(new File("C:\\Users\\nitesh.gupta\\Downloads"));
		node = directoryReader.getDirectoryTree();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("File Structure View");

		TreeItem<String> rootItem = new TreeItem<String>(node.getName());
		rootItem.setExpanded(true);
		for (Node node : node.getChildNodes()) {
			if (node.isLeafNode()) {
				TreeItem<String> item = new TreeItem<String>(node.getName());
				rootItem.getChildren().add(item);
			}
		}
		
		TreeView<String> tree = new TreeView<String>(rootItem);
		StackPane root = new StackPane();
		root.getChildren().add(tree);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
