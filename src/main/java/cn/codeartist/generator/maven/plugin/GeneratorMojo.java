package cn.codeartist.generator.maven.plugin;

import cn.codeartist.code.generator.session.GenSession;
import cn.codeartist.code.generator.session.GenSessionFactory;
import cn.codeartist.code.generator.session.defaults.BaseGenSessionFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "generator")
public class GeneratorMojo extends AbstractMojo {

    @Parameter
    private File configFile;

    public void execute() {
        if (configFile == null) {
            getLog().error("配置文件不能为空");
            return;
        }
        getLog().info("配置文件路径: " + configFile.getName());
        getLog().info("开始生成源代码......");
        GenSessionFactory factory = new BaseGenSessionFactory().build(configFile);
        GenSession session = factory.openSession();
        session.generate();
        getLog().info("生成源代码完成");
    }

}
