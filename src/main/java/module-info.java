module edu.raycon {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.raycon to
      javafx.fxml;

  exports edu.raycon;
}
