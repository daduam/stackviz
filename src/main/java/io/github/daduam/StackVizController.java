package io.github.daduam;

import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

// TODO
// reverse listview order (flip)

public class StackVizController {
  private Stack<String> stack;

  public StackVizController() {
    stack = new Stack<String>();
  }

  @FXML
  private void initialize() {
    disablePopButtonIfStackIsEmpty();
  }

  @FXML
  private TextField stackItemTextField;

  @FXML
  private Button pushButton;

  @FXML
  private Button popButton;

  @FXML
  private ListView<String> listView;

  @FXML
  private void handlePushButtonAction() {
    pushItemToStack(stackItemTextField.getText());
    stackItemTextField.clear();
    popButton.setDisable(false);
  }

  @FXML
  private void handlePopButtonAction() {
    popItemFromStack();
    disablePopButtonIfStackIsEmpty();
  }

  private void pushItemToStack(String item) {
    if (item.isEmpty()) {
      return;
    }
    stack.push(item);
    listView.getItems().add(item);
  }

  private void popItemFromStack() {
    if (stack.isEmpty()) {
      return;
    }
    stack.pop();
    listView.getItems().remove(listView.getItems().size() - 1);
  }

  private void disablePopButtonIfStackIsEmpty() {
    if (stack.isEmpty()) {
      popButton.setDisable(true);
    }
  }
}
