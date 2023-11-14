import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Base64App {

    private static final Logger logger = LogManager.getLogger(Base64App.class);

    public static String imageToBase64(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            byte[] imageBytes = Files.readAllBytes(path);
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    public static void base64ToImage(String base64Image, String newImagePath) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            Files.write(Paths.get(newImagePath), imageBytes);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public static void main(String[] args) {
        String imagePath = "src/main/resources/TEST_IMG.PNG";

        String base64Image = imageToBase64(imagePath);
        logger.info("base64Image: ".concat(base64Image));

        String newImagePath = "src/main/resources/RET_IMG.jpg";
        base64ToImage(base64Image, newImagePath);
    }
}