package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        // bana icinde bulndugum projenin dosya yolunu verir
        System.out.println(System.getProperty("user.home"));
        // C:\Users\admin benim bilgisyarimin bana ozel kismini verir.

        // Soru: Masaustundeki text dosyasinin varligini test edin.
        // C:\Users\admin\Desktop\Text.txt
        String filePath = System.getProperty("user.home")+"//Desktop//Text.txt";
        System.out.println(filePath);


        String uniquePath = System.getProperty("user.home");
        String commonPath = "\\Desktop\\text.txt";
        String wholePath = uniquePath+commonPath;
        Assert.assertTrue(Files.exists(Paths.get(wholePath)));
    }

}
