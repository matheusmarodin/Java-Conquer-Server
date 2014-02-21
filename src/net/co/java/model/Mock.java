package net.co.java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import net.co.java.entity.Monster;
import net.co.java.entity.Player;
import net.co.java.item.EquipmentSlot;
import net.co.java.item.ItemInstance;
import net.co.java.item.ItemInstance.EquipmentInstance;
import net.co.java.item.ItemPrototype.EquipmentPrototype;
import net.co.java.item.ItemPrototype;
import net.co.java.server.Server.Map;

/**
 * The Mock model is a model using mock data and is mainly for
 * developing and testing purposes.
 * @author Jan-Willem Gmelig Meyling
 *
 */
public class Mock extends AbstractModel {
	
	public Mock() throws FileNotFoundException {
		createSomeStuff();
	}
	
	private void createSomeStuff() throws FileNotFoundException{
		System.out.println("Creating the magical world of Conquer Online");
		// We spawn a BullMessenger in Twin City for testing purposes here
		Map.CentralPlain.addEntity(new Monster(Map.CentralPlain.new Location(378, 343), 564564, "BullMessenger",  112, 117, 55000));
		// Load the item data
		ItemPrototype.read(new File("ini/COItems.txt"));
		// Create an item
		new EquipmentInstance(2342239l, (EquipmentPrototype) ItemPrototype.get(480029l))
			.setFirstSocket(EquipmentInstance.Socket.SuperFury)
			.setSecondSocket(EquipmentInstance.Socket.SuperRainbowGem)
			.setDura(1500).setBless(3).setPlus(7).setEnchant(172);
	}
	
	@Override
	public boolean isAuthorised(String server, String username, String password) {
		return true;
	}

	@Override
	public boolean hasCharacter(String server, String username) {
		return true;
	}

	@Override
	public ItemInstance[] getInventory(Player player) {
		return new ItemInstance[] { EquipmentInstance.get(2342239l) };
	}

	@Override
	public HashMap<EquipmentSlot, EquipmentInstance> getEquipments(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemPrototype getItemPrototype(long staticID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemInstance getItemInstance(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getIdentity(String character) throws AccessException {
		Long identity = this.createPlayerIdentity();
		Player player = new Player(identity, character, null, 500);
		player.setMesh(381004);
		player.setHairstyle(315);
		player.setGold(1111);
		player.setCps(215);
		player.setExperience(34195965);
		player.setStrength(51);
		player.setDexterity(50);
		player.setVitality(50);
		player.setSpirit(50);
		player.setAttributePoints(200);
		player.setHP(500);
		player.setPkPoints(10);
		player.setMana(120);
		player.setLevel(130);
		player.setRebornCount(0);
		player.setProfession(15);
		this.players.put(identity, player);
		return identity;
	}

	@Override
	protected ItemPrototype fetchItemPrototype(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ItemInstance fetchItemInstance(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}