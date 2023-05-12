package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest {
    @Test
    public void test01(){
        //pom.Team113Junit projesi içerisinde deneme.txt dosyasının var oldugunu test edin

        String dosyaYolu="src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }










}
