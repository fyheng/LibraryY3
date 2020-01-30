package picture;

import javax.swing.ImageIcon;

import admin.Home;

public class GetIcon {
	public static String getIconPath(Icons icon) {
		String name = "";
		if(icon == Icons.Book) {
			name = "book.png";
		}else if(icon == Icons.User) {
			name = "user.png";
		}else if(icon == Icons.MaleUser) {
			name = "male.png";
		}else if(icon == Icons.FemaleUser) {
			name = "female.png";
		}
//		icon = Icons.Book;
//		switch(icon) {
//		  case Book:
//			  name = "book.png";
//		  case User:
//			  name = "user.png";
//		  case MaleUser:
//			  name = "male.png";
//		  case FemaleUser:
//			  name = "female.png";
//		}
		return name;
	}
	public static ImageIcon setIcon(Icons icons) {
		String path = "/picture/"+getIconPath(icons);
		return new ImageIcon(Home.class.getResource(path));
	}
}
