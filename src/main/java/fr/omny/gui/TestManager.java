package fr.omny.gui;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import fr.omny.guis.OClass;
import fr.omny.guis.OField;
import fr.omny.guis.fields.ItemField;
import lombok.Getter;
import lombok.Setter;

@OClass
@Getter
public class TestManager {

	@OField
	private List<TestObject> list = new ArrayList<>();

	public TestManager() {

	}

	@OClass
	@Getter
	@Setter
	public static class TestObject {

		@OField
		private String name = "empty";

		@OField(display = Material.PAPER)
		private int count = 5;

		@OField
		private ItemField item = new ItemField();

	}

}
