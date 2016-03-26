package io.jpress.core.generator;

import com.jfinal.plugin.activerecord.generator.ModelGenerator;
import com.jfinal.plugin.activerecord.generator.TableMeta;

public class JModelGenerator extends ModelGenerator {

	public JModelGenerator(String modelPackageName,
			String baseModelPackageName, String modelOutputDir) {
		super(modelPackageName, baseModelPackageName, modelOutputDir);
		
		this.importTemplate = "import io.jpress.core.annotation.Table;%n"
				+ "import %s.%s;%n%n";
		
		this.classDefineTemplate =
				"/**%n" +
				" * Generated by JPress.%n" +
				" */%n" +
				"@Table(tableName=\"%s\",primaryKey=\"%s\")%n" +
				"public class %s extends %s<%s> {%n";
		
		
		this.daoTemplate = "\tprivate static final long serialVersionUID = 1L;%n%n"
				+ "\tpublic static final %s DAO = new %s();%n";
		
		
	}
	
	@Override
	protected void genClassDefine(TableMeta tableMeta, StringBuilder ret) {
		ret.append(String.format(classDefineTemplate, tableMeta.name,tableMeta.primaryKey,tableMeta.modelName, tableMeta.baseModelName, tableMeta.modelName));
	}

		
		

}