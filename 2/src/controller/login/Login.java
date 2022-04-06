package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Login implements Initializable{

	public static Login instance;
	
	public Login() {instance = this; }
	
	
    @FXML
    private MediaView mediaview;

    @FXML
    private BorderPane borderpane2;
    
    // * �α��� ������ ȸ����ü
    public static Member member;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// 1. ������ �����ϱ�
    		// 1. ���������� ��üȭ
    		Media media = new Media(getClass().getResource("/img/login.mp4").toString());
    		// 2. �̵���÷��̾� ��ü�� ������ �ֱ�
    		MediaPlayer mediaPlayer = new MediaPlayer(media);
    		// 3. �̵��信 �̵���÷��̾� �ֱ�
    		mediaview.setMediaPlayer(mediaPlayer);
    		// 4. �̵�� �÷��̾� ����
    		mediaPlayer.play();
    		mediaPlayer.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
				}
			});
    		loadpage("/view/login/loginpane.fxml");
    }
    
    public void loadpage(String page) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource(page));
    		borderpane2.setCenter(parent);
    	} catch (Exception e) {System.out.println("�ش� ������ �����ϴ�. "+e);}
    }
   
	
}