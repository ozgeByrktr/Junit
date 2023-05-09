package Day06_JunitFramework;

import org.junit.Assert;

public class C04_assrtionMethodlari {
    public void test01(){
        /*
        Eger testin sonucunu turkce olarak olumlu bir cumle ile sorduysa assertTrue
        olumsuz cumle kullanılmıssa
         */
        int sayi1=20;
        int sayi2=10;
        int sayi3=30;

        //sayi2<sayi1 oldugunu test edin

        Assert.assertTrue(sayi2<sayi1);

        //sayi1'in sayi3'ten büyük olmadıgını test edin

        Assert.assertFalse(sayi1>sayi3);

        //sayi 1 'in sayi3'den kucuk oldugunu test edin

        Assert.assertTrue(sayi1<sayi3);


    }
}
