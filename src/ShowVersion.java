import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * Created by lianhua on 17/2/16.
 */
public class ShowVersion implements ProjectComponent {
    String versionName;
    public ShowVersion(Project project) {
//        PsiFile[] filesByName = FilenameIndex.getFilesByName(project, "build.gradle", GlobalSearchScope.projectScope(project));
//        for (PsiFile psiFile : filesByName) {
//            if ("app".equals(psiFile.getParent().getName())) {
//                psiFile.getNode().getPsi();
//                String text = ((FileElement) psiFile.getNode()).getChildren(TokenSet.ANY)[2].getText();
//                String[] strs = text.split("versionName");
//                versionName = strs[1].substring(0, 15);
//            }
//        }
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "ShowVersion";
    }

    @Override
    public void projectOpened() {
        // called when project is opened
       // Messages.showMessageDialog("Hello World !"+versionName, "Information"+versionName, Messages.getInformationIcon());
    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }
}
