package nu.jixa.its;

import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nu.jixa.its.model.Issue;
import nu.jixa.its.model.Status;
import nu.jixa.its.model.User;
import nu.jixa.its.model.WorkItem;

import static org.junit.Assert.assertNotNull;

public final class HelperMethods {

  public static User generateSimpleUser(@NotNull final Long number) {
    return new User(number, "account" + number, "firstname" + number, "lastname" + number);
  }
  public static final Long USER_NUMBER = 100L;
  /**
   * Returns true if all elements in set1 is present in set2 and, vice versa.
   */
  public static <T> boolean isEqualSet(Set<T> set1, Set<T> set2) {
    int matchesInColl1 = 0;
    for (T item : set1) {
      if (set2.contains(item)) {
        matchesInColl1 += 1;
      }
    }
    if (matchesInColl1 == set2.size()) {
      return true;
    }
    return false;
  }

  /**
   * Converts an iterable to a HashSet, if it only contains unique elements.
   * Otherwise throws IllegalArgumentException.
   */
  public static <T> HashSet<T> toHashSet(Iterable<T> iterable) {
    HashSet<T> newSet = new HashSet<T>();
    for (T item : iterable) {
      if (newSet.add(item) == false) {
        throw new IllegalArgumentException(
            "Cannot convert iterable to set: iterable contains duplicate elements");
      }
    }
    return newSet;
  }

  /**
   * Converts an array to a HashSet, if it only contains unique elements.
   * Otherwise throws IllegalArgumentException.
   */
  public static <T> HashSet<T> toHashSet(T[] items)
  {
    HashSet<T> newSet = new HashSet<>();
    for(int i = 0; i < items.length; i++)
    {
      if (newSet.add(items[i]) == false) {
        throw new IllegalArgumentException(
            "Cannot convert array to set: array contains duplicate elements");
      }
    }
    return newSet;
  }

  /**
   *
   *  ------- WorkItem methods ------
   */

  public static List<WorkItem> generateComplexWorkItems() {
    ArrayList<WorkItem> list = new ArrayList<>();
    WorkItem workItemStatus1 = generateSimpleWorkItem(12L);
    workItemStatus1.setDescription("item 1");
    workItemStatus1.setIssue(new Issue(20L));
    //workItemStatus1.setUsers(generate1Users());
    workItemStatus1.setStatus(Status.DONE);

    WorkItem workItemStatus2 = generateSimpleWorkItem(14L);
    workItemStatus1.setDescription("item 2");
    workItemStatus1.setIssue(new Issue(22L));
    //workItemStatus1.setUsers(generate2Users());
    workItemStatus1.setStatus(Status.DONE);

    WorkItem workItemStatus3 = generateSimpleWorkItem(16L);
    workItemStatus1.setDescription("item 1");
    workItemStatus1.setIssue(new Issue(244L));
    //workItemStatus1.setUsers(generate3Users());
    workItemStatus1.setStatus(Status.DONE);

    list.add(workItemStatus1);
    list.add(workItemStatus2);
    list.add(workItemStatus3);
    return list;
  }
  public static WorkItem generateSimpleWorkItem(@NotNull final Long number) {
    Status status = Status.ON_BACKLOG;
    return new WorkItem(number, status);
  }

  public static Collection<User> generate3Users(){
    Collection<User> users = new ArrayList();
    users.add(generateSimpleUser(USER_NUMBER));
    users.add(generateSimpleUser(12L));
    users.add(generateSimpleUser(14L));
    return users;
  }
  public static Collection<User> generate2Users(){
    Collection<User> users = new ArrayList();
    users.add(generateSimpleUser(USER_NUMBER));
    users.add(generateSimpleUser(12L));
    return users;
  }
  public static Collection<User> generate1Users(){
    Collection<User> users = new ArrayList();
    users.add(generateSimpleUser(USER_NUMBER));
    return users;
  }

}
