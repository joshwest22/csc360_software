import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.StoreModel;
import models.ViewTransitionalModel;
import views.MainController;

public class Main extends Application
{

	@Override
	public void start(Stage stage) throws Exception
	{
		StoreModel model = new StoreModel();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));
		BorderPane view = loader.load();
		MainController controller = loader.getController();
		ViewTransitionalModel vm = new ViewTransitionalModel(view, model);
		controller.setModel(vm);
		vm.showCash(); //view up automatically
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}

}
