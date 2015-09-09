package nu.jixa.its;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*

FUNKTIONSKRAV
 ____________________________________________________
| Location  | Requirement                           |
USER
✓User       | Skapa en User
✓User       | Uppdatera en User
✓User       | Ta bort* en User
✓User       | Hämta en User baserat på user id (inte entity id)
✓User       | Söka efter en User baserat på förnamn eller efternamn eller användarnamn
✓UserTeam   | Hämta alla User som ingår i ett visst team

TEAM
✓Team       | Skapa ett team
✓Team       | Uppdatera ett team
✓Team       | Ta bort* ett team
✓Team       | Hämta alla team
✓UserTeam   | Lägga till en User till ett team

WorkItem
            | Skapa en work item
            | Ändra status på en work item
            | Ta bort* en work item
            | Tilldela en work item till en User
            | Hämta alla work item baserat på status
            | Hämta alla work item för ett Team
            | Hämta alla work item för en User
            | Söka efter work item som innehåller en viss text i sin beskrivning

Issue
            | Issue
            | Skapa en Issue
            | Uppdatera en Issue
            | Lägga till en Issue till en work item
            | Hämta alla work item som har en Issue
*/

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ModelUtilTest.class,
    UserRepositoryTest.class,
    UserTeamRepositoryTest.class,
    WorkItemRepositoryTest.class,
    TeamRepositoryTest.class
})
public class AllTestsSuite {
}
