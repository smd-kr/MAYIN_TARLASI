import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.TreeUI;

public class BAŞLATICI {
	int satır;
	int sütun;
	Object [][] asıl_tablo;
	Object [][] kullanıcı_tablosu;
	Scanner scan=new Scanner(System.in);
	Random random=new Random();
	int sonuç=24;
	public BAŞLATICI(int satır,int sütun) {
		this.satır=satır;
		this.sütun=sütun;
	}
	public void tablo_oluşturucu() {
		asıl_tablo=new String[satır][sütun];
		int x=0;
		for (int i=0;satır>i;i++) {
			for (int j=0;sütun>j;j++) {
				asıl_tablo[i][j]="x";
			}
		}
		while(((satır*sütun)/4)>x) {
			int a=random.nextInt(satır);
			int b=random.nextInt(sütun);
			if (asıl_tablo[a][b].equals("x")) {
				asıl_tablo[a][b]=("-1");
				x++;
			}
		}
		kullanıcı_tablosu=new String[satır][sütun];
		for (int i=0;satır>i;i++) {
			for (int j=0;sütun>j;j++) {
				kullanıcı_tablosu[i][j]="x";
			}
		}
	}
	public void tablo_gösterici() {
		for (int i=0;asıl_tablo.length>i;i++) {
			for (int n=0;asıl_tablo[i].length>n;n++) {
				if (asıl_tablo[i][n].equals("x")) System.out.print(" "+asıl_tablo[i][n]);
				else{
					System.out.print(asıl_tablo[i][n]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public void kullanıcı_tablo_gösterici(){

		for (int i=0;kullanıcı_tablosu.length>i;i++) {
			for (int n=0;kullanıcı_tablosu[i].length>n;n++) {
				System.out.print(" "+kullanıcı_tablosu[i][n]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public void oyun_başlatıcı() {
		sonuç--;
		tablo_oluşturucu();
		tablo_gösterici();
		boolean değer=true;
		int k_satır;
		int k_sütun;
		while(değer) {
		System.out.print("Satır giriniz:");
		k_satır=scan.nextInt();
		System.out.print("Sütun giriniz:");
		k_sütun=scan.nextInt();
		k_satır-=1;
		k_sütun-=1;
		if (asıl_tablo[k_satır][k_sütun].equals("-1")) {
			System.out.println("KAYBETTİN");
			değer=false;
			continue;
		}
		else {
			int m=0;
			if((k_sütun+1)<8 && asıl_tablo[k_satır][k_sütun+1].equals("-1")) m++;
			if((k_satır+1)<4 && asıl_tablo[k_satır+1][k_sütun].equals("-1")) m++;
			if((k_satır-1)>=0 && asıl_tablo[k_satır-1][k_sütun].equals("-1")) m++;
			if((k_sütun-1)>=0 && asıl_tablo[k_satır][k_sütun-1].equals("-1")) m++;
			if (m==4) kullanıcı_tablosu[k_satır][k_sütun]="4";
			if (m==3) kullanıcı_tablosu[k_satır][k_sütun]="3";
			if (m==2) kullanıcı_tablosu[k_satır][k_sütun]="2";
			if (m==1) kullanıcı_tablosu[k_satır][k_sütun]="1";
			if (m==0) kullanıcı_tablosu[k_satır][k_sütun]="0";
			
			kullanıcı_tablo_gösterici();
			if (kullanıcı_tablosu[k_satır][k_sütun]=="4") sonuç--;
			if (kullanıcı_tablosu[k_satır][k_sütun]=="3") sonuç--;
			if (kullanıcı_tablosu[k_satır][k_sütun]=="2") sonuç--;
			if (kullanıcı_tablosu[k_satır][k_sütun]=="1") sonuç--;
			
			if (sonuç==0) {
				System.out.println("OYUNU KAZANDIN");
				değer=false;
				continue;
			

			}}
}

}
}
