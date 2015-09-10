package nu.jixa.its.model;

import com.sun.istack.internal.NotNull;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblWorkItem")
public class WorkItem extends AbstractEntity<WorkItem> {

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private Status status;

  @Column(name = "description")
  private String description;

  @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn
  private Issue issue;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "workItems")
  Collection<User> users;

  protected WorkItem() {
  }

  @Override public void copyFields(WorkItem other) {
    this.status = other.status;
    this.description = other.description;
    this.issue = other.issue;
    this.users = other.users;
  }

  public WorkItem(Long number, Status status) {
    this.number = number;
    this.status = status;
  }
  public Status getStatus() {
    return status;
  }

  public void setStatus(@NotNull final Status status) {
    ModelUtil.throwExceptionIfArgIsNull(status, "status");
    this.status = status;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    ModelUtil.throwExceptionIfArgIsNull(description, "description");
    this.description = description;
  }
  public User addUser(User user){

    if (checkIfUserExist(user)){
      throw new RepositoryModelException("the user already exist");
    }
    return user;
  }

  private boolean checkIfUserExist(User user) {
    for(User userInUsers: users){
      if(user.equals(userInUsers)){
        return true;
      }
    } return false;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  public Collection<User> getUsers() {
    return users;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WorkItem workItem = (WorkItem) o;

    if (!getNumber().equals(workItem.getNumber())) return false;
    if (getStatus() != workItem.getStatus()) return false;
      return !(getIssue() != null ? !getIssue().equals(workItem.getIssue())
        : workItem.getIssue() != null);
  }

  @Override public int hashCode() {
    int result = getNumber().hashCode();
    result = 31 * result + getStatus().hashCode();
    result = 31 * result + (getIssue() != null ? getIssue().hashCode() : 0);
    return result;
  }
}
