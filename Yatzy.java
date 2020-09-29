package FactorisationJ8;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {

	/******** Chance *********/
	public static int chance(int d1, int d2, int d3, int d4, int d5) {
		int[] array = { d1, d2, d3, d4, d5 };
		int total = Arrays.stream(array).sum();

		return total;
	}

	/******* Yatzy: *********/

	public static int yatzy(int... dice) {
		IntStream intStream1 = Arrays.stream(dice).distinct();

		if (intStream1.count() == 1) {
			return 50;
		}

		return 0;
	}

	/******
	 * Ones, Twos, Threes, Fours, Fives, Sixes depending c= ... 1,2,3,4
	 *******/
	public static int calcul_score(int[] array, int c) {
		int sum = 0;
		IntStream intStream1 = Arrays.stream(array).filter(i -> i == c);
		sum = (int) intStream1.count();

		return sum * c;
	}

	/***** Pair ********/

	public static int calcul_score_max_pair(int[] array, int c) {

		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(array[0]);
		list.add(array[1]);
		list.add(array[2]);
		list.add(array[3]);
		list.add(array[4]);

		Set<Integer> listSet = new HashSet<Integer>();

		listSet = list.stream().sorted().filter(i -> Collections.frequency(list, i) > c - 1)
				.collect(Collectors.toSet());

		sum = listSet.stream().max(Comparator.comparing(Integer::valueOf)).get() * c;

		return sum;
	}

	/******** Two pairs *****/

	public static int calcul_two_score_pair(int[] array, int c) {

		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(array[0]);
		list.add(array[1]);
		list.add(array[2]);
		list.add(array[3]);
		list.add(array[4]);

		Set<Integer> listSet = new HashSet<Integer>();

		listSet = list.stream().sorted().filter(i -> Collections.frequency(list, i) > c - 1)
				.collect(Collectors.toSet());

		int leng = listSet.size();

		if (leng == 2) {

			sum = listSet.stream().findFirst().get() * c + listSet.stream().reduce((first, second) -> second).get() * c;

			return sum;
		}

		return sum;

	}

	/****** Three of a kind and Four of a kind depending c=2 or c =3 *****/

	public static int calcul_sum_score_pair(int[] array, int c) {

		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(array[0]);
		list.add(array[1]);
		list.add(array[2]);
		list.add(array[3]);
		list.add(array[4]);

		Set<Integer> listSet = new HashSet<Integer>();

		listSet = list.stream().sorted().filter(i -> Collections.frequency(list, i) > (c - 1))
				.collect(Collectors.toSet());

		int leng = listSet.size();

		if (leng > 0 && c == 3) {

			sum = listSet.stream().findFirst().get() * c;

			return sum;
		}

		if (leng > 0 && c == 4) {

			sum = listSet.stream().findFirst().get() * 4;

			return sum;
		}
		return sum;
	}

	/******
	 * Small straight and Large straight: depending issmall true or false
	 ******/

	public static int straight(int[] array1, boolean issmall) {

		List<Boolean> equalityResult = null;
		// smallStraightJ8 ,
		int[] array_small = { 1, 2, 3, 4, 5 };
		int[] array_straight = { 2, 3, 4, 5, 6 };

		if (issmall) {
			equalityResult = IntStream.range(0, array1.length).mapToObj(i -> array1[i] == array_small[i])
					.collect(Collectors.toList());
			equalityResult.stream().distinct().count();

		} else {

			equalityResult = IntStream.range(0, array1.length).mapToObj(i -> array1[i] == array_straight[i])
					.collect(Collectors.toList());
			equalityResult.stream().distinct().count();

		}

		if (equalityResult.stream().distinct().count() == 1 && issmall) {
			return 15;
		}

		if (equalityResult.stream().distinct().count() == 1 && !issmall) {
			return 20;
		}

		return 0;
	}

	/********** Full house **********/

	public static int fullHouse(int[] array) {

		long sized = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(array[0]);
		list.add(array[1]);
		list.add(array[2]);
		list.add(array[3]);
		list.add(array[4]);

		sized = list.stream().distinct().count();
		int sumC = Arrays.stream(array).sum();
		Set<Integer> listSet1 = new HashSet<Integer>();
		Set<Integer> listSet2 = new HashSet<Integer>();

		if (sized == 2) {

			listSet1 = list.stream().sorted().filter(i -> Collections.frequency(list, i) > 1)
					.collect(Collectors.toSet());

			listSet2 = list.stream().sorted().filter(i -> Collections.frequency(list, i) > 2)
					.collect(Collectors.toSet());

			if ((listSet1.size() == 2 && listSet2.size() == 1)) {
				return sumC;
			}
		}
		return 0;
	}

}
