import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class SolutionTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Solution.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void mergeTwoLists() {
        ListNode l1 = ListNode.deserialize("[1, 2, 4]");
        ListNode l2 = ListNode.deserialize("[1, 3, 4]");

        Solution s = new Solution();
        ListNode l = s.mergeTwoLists(l1, l2);

    }

}
