package picture;

import javax.swing.ImageIcon;

import admin.AdminHome;

public class GetIcon {
	public static String getIconPath(Icons icon) {
		String name = "";
		if (icon == Icons.Book) {
			name = "bookicon.png";
		} else if (icon == Icons.User) {
			name = "user.png";
		} else if (icon == Icons.MaleUser) {
			name = "male.png";
		} else if (icon == Icons.FemaleUser) {
			name = "female.png";
		}else if (icon == Icons.Close) {
			name = "close.png";
		}
		return name;
	}

	public static ImageIcon setIcon(Icons icons) {
		String path = "/picture/" + getIconPath(icons);
		return new ImageIcon(AdminHome.class.getResource(path));
	}
}
