import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

class Base64AppTest {

    @Test
    void testImageToBase64() {
        String imagePath = "src/main/resources/TEST_IMG.PNG";
        String base64Image = Base64App.imageToBase64(imagePath);

        assertNotNull(base64Image);
        assertFalse(base64Image.isEmpty());
    }

    @Test
    void testBase64ToImage() {
        String imagePath = "src/main/resources/TEST_IMG.PNG";
        String base64Image = Base64App.imageToBase64(imagePath);

        String newImagePath = "src/main/resources/RET_IMG.jpg";
        Base64App.base64ToImage(base64Image, newImagePath);

        assertTrue(Files.exists(Paths.get(newImagePath)));
    }

    @Test
    void testMainMethod() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Base64App.main(new String[]{});

        System.setOut(System.out);
        String consoleOutput = outputStream.toString().trim();

        assertNotNull(consoleOutput);
        assertFalse(consoleOutput.contains("Error"));
    }
}