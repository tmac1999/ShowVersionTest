import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lianhua on 17/2/20.
 */
public class ShowVersionWindowFactory implements ToolWindowFactory{
    private Project project;


   // public static  final Icon icon = load("");
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        toolWindow.setTitle("ShowVersion111111");
        toolWindow.setIcon(load("image/lil_nemo.png"));
        this.project = project;
        ContentManager contentManager = toolWindow.getContentManager();
        Content heheh = contentManager.getFactory().createContent(new ShowVersionJComponent(), "VersionList", true);
        contentManager.addContent(heheh);
    }
    private static Icon load(String path) {
        try {
            return IconLoader.getIcon(path, ShowVersionWindowFactory.class);
        } catch (IllegalStateException e) {
            return null;
        }
    }



    private static String FILE_SYSTEM_LABEL = "FileSystem";
    private static String URL_LABEL = "URL";
    private class ShowVersionJComponent extends JComponent{

        private JTextField fileSystemFilename;
        private CheckboxGroup cbxgrpFileType;
        private Checkbox cbxFileSystem;
        private Checkbox cbxUrl;
        private Checkbox cbxEnabled;
        private JButton btnProject;
        private JLabel imageLabel;


        public ShowVersionJComponent() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints gb = new GridBagConstraints();
            Insets defaultInsets = new Insets(5, 5, 5, 5);
            gb.insets = defaultInsets;




            ApplicationManager.getApplication().runReadAction(new Runnable() {
                @Override
                public void run() {
                    PsiFile[] filesByName = FilenameIndex.getFilesByName(project, "build.gradle", GlobalSearchScope.projectScope(project));
                    for (PsiFile psiFile : filesByName) {
                       // if ("app".equals(psiFile.getParent().getName())) {
                           // psiFile.getNode().getPsi();
                            String text = psiFile.getText();
                            String[] strs = text.split("versionName");
                            if (strs.length>1){
                                String versionName = strs[1].substring(0, 10);

                                System.out.println("Module !"+versionName);
                                ApplicationManager.getApplication().invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Messages.showMessageDialog("Module !"+versionName, "Module"+versionName, Messages.getInformationIcon());
                                        String replace = versionName.replace("\"", "");
                                        if(judgeContainsStr(replace.trim())){
                                            //contains English letter
                                            String[] strs = text.split(replace);//fixme find the real version name
                                            String versionName = strs[1].substring(0, 10);
                                            replace = versionName.replace("\"", "");
                                        }
                                        setText(gb,psiFile.getParent().getName()+":"+replace);

                                    }
                                });
                            }
                        // }


                    }
                }
            });

        }

        private void setText(GridBagConstraints gb,String text) {
            TextArea textArea = new TextArea(text);
            textArea.setSize(150,130);
            textArea.setEnabled(false);
            textArea.setFont(new Font("黑体",Font.BOLD,16));

            textArea.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    Point point = e.getPoint();
                    Messages.showMessageDialog(text, "Information", Messages.getInformationIcon());
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    Point point = e.getPoint();
                    Messages.showMessageDialog(text, "Information", Messages.getInformationIcon());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    Point point = e.getPoint();
                    Messages.showMessageDialog(text, "Information", Messages.getInformationIcon());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    Point point = e.getPoint();
                    Messages.showMessageDialog(text, "Information", Messages.getInformationIcon());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    Point point = e.getPoint();
                    Messages.showMessageDialog(text, "Information", Messages.getInformationIcon());
                }
            });

            gb.gridx = 25;
            gb.gridy++;
            gb.weightx = 5.0D;
            gb.weighty = 1.0D;
            gb.fill = 5;
            this.add(textArea,gb);
        }


        @Override
        public void setName(String name) {
            super.setName(name);
        }


        @Override
        protected void setUI(ComponentUI newUI) {

            super.setUI(newUI);
        }


    }

    public boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }
}
