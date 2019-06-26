package data_structures;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import model.Player;
import org.junit.Test;

@Slf4j
public class SortCollections extends CommonData {

	@Test
	public void sortItemsInArrayList() {
		List<Player> players = new ArrayList<>();
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		log.error("sortItemsInArrayList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 14 millis
	}

	@Test
	public void sortItemsInLinkedList() {
		List<Player> players = new LinkedList<>();
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		players.sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		log.error("sortItemsInLinkedList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 69 millis
	}

	@Test
	public void sortItemsInHashSetUsingStreamAPI() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		players.stream()
			.sorted(Comparator.comparing(Player::getDescription))
			.collect(Collectors.toCollection(LinkedHashSet::new));
		var end = System.nanoTime();

		log.error("sortItemsInHashSetUsingStreamAPI() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 1 millis
	}

	@Test
	public void sortItemsInHashSetUsingList() {
		Set<Player> players = new HashSet<>();
		addMillionPlayers(player, players);

		var start = System.nanoTime();
		new ArrayList<>(players).sort(Comparator.comparing(Player::getDescription));
		var end = System.nanoTime();

		log.error("sortItemsInHashSetUsingList() = " + MILLISECONDS.convert(end - start, NANOSECONDS));
		// Execution time: 1 millis
	}

}