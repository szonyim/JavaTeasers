package hu.isilent.teasers.fiftytwo;

public class Cache {

  // 1. inicializálás - ez meg fog hívódni
  static {
    initalizeIfNecessary();
  }

  private static int sum;

  public static int getSum() {
    initalizeIfNecessary();
    return sum;
  }

  // 2. inicializálás - Mivel az érték adás is inicializálásnak minősül, ezért újra beállításra kerül a false érték
  private static boolean initialized = false;

  private static synchronized void initalizeIfNecessary() {
    if (!initialized) {
      for (int i = 0; i < 100; i++) {
        sum += i;
        initialized = true;
      }
    }
  }

}
