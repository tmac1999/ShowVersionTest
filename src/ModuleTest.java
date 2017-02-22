import com.intellij.ide.projectView.ProjectView;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.FileChooserUI;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lianhua on 17/2/16.
 */
public class ModuleTest implements ModuleComponent {
    String versionName;
    Module module;
    public ModuleTest(Module module) {

//        PsiFile[] filesByName = FilenameIndex.getFilesByName(module.getProject(), "build.gradle", GlobalSearchScope.projectScope(module.getProject()));
//        for (PsiFile psiFile : filesByName) {
//            if ("app".equals(psiFile.getParent().getName())) {
//                psiFile.getNode().getPsi();
//                String text = ((FileElement) psiFile.getNode()).getChildren(TokenSet.ANY)[2].getText();
//                String[] strs = text.split("versionName");
//                versionName = strs[1].substring(0, 15);
//            }
//        }
        this.module = module;
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        initMessageQueue();
    }

    private void initMessageQueue() {
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "ModuleVersion";
    }

    @Override
    public void projectOpened() {
        // called when project is opened
    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }

    @Override
    public void moduleAdded() {
        // Invoked when the module corresponding to this component instance has been completely
        // loaded and added to the project.
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new DispatchThread(countDownLatch).start();


//        VirtualFile moduleFile = module.getModuleFile();
//        VirtualFile child = moduleFile.findChild("build.gradle");
        ProjectView instance = ProjectView.getInstance(module.getProject());
        PsiElement parentOfCurrentSelection = instance.getParentOfCurrentSelection();
    }
    class DispatchThread extends Thread{
        CountDownLatch countDownLatch;
        public DispatchThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();


            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            Annotator annotator = new Annotator() {
                @Override
                public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {

                }
            };
        }
    }

}
