import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.R;

public class App extends Application {

    private Stage stagePrincipal;
    private VBox vbox;

    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("ui.fxml"));
        loader.setController(new AppController());
        vbox = loader.load();

        Scene scene = new Scene(vbox);
        stagePrincipal.setScene(scene);
        stagePrincipal.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
