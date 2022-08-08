package io.github.daduam;

import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// todo
// show items in ListView

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
  private void handlePushButtonAction() {
    String newItem = stackItemTextField.getText();
    pushItemToStack(newItem);
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
    // update ListView
    System.out.println(stack);
  }

  private void popItemFromStack() {
    stack.pop();
    // update ListView
    System.out.println(stack);
  }

  private void disablePopButtonIfStackIsEmpty() {
    if (stack.isEmpty()) {
      popButton.setDisable(true);
    }
  }
}
