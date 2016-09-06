// Generated from D:\EclipseProjects\SimpleLanguage\src\br\erickweil\simplelang\generated\Simple.g4 by ANTLR 4.5.3

    package br.erickweil.simplelang.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SimpleParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SimpleParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(SimpleParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(SimpleParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(SimpleParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(SimpleParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(SimpleParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(SimpleParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(SimpleParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(SimpleParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(SimpleParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(SimpleParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(SimpleParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(SimpleParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(SimpleParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(SimpleParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(SimpleParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(SimpleParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(SimpleParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(SimpleParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(SimpleParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(SimpleParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(SimpleParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(SimpleParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(SimpleParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(SimpleParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(SimpleParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(SimpleParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(SimpleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(SimpleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(SimpleParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(SimpleParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(SimpleParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(SimpleParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(SimpleParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(SimpleParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(SimpleParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(SimpleParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(SimpleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(SimpleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(SimpleParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(SimpleParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(SimpleParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(SimpleParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(SimpleParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(SimpleParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(SimpleParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(SimpleParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(SimpleParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(SimpleParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(SimpleParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(SimpleParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(SimpleParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(SimpleParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(SimpleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(SimpleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(SimpleParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(SimpleParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(SimpleParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(SimpleParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(SimpleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(SimpleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(SimpleParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(SimpleParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(SimpleParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(SimpleParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(SimpleParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(SimpleParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(SimpleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(SimpleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(SimpleParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(SimpleParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(SimpleParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(SimpleParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(SimpleParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(SimpleParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(SimpleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(SimpleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(SimpleParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(SimpleParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(SimpleParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(SimpleParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(SimpleParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(SimpleParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(SimpleParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(SimpleParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(SimpleParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(SimpleParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(SimpleParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(SimpleParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(SimpleParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(SimpleParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(SimpleParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(SimpleParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(SimpleParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(SimpleParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(SimpleParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(SimpleParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SimpleParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SimpleParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SimpleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SimpleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(SimpleParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(SimpleParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(SimpleParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(SimpleParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(SimpleParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(SimpleParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(SimpleParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(SimpleParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(SimpleParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(SimpleParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(SimpleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(SimpleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(SimpleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(SimpleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(SimpleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(SimpleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(SimpleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(SimpleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(SimpleParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(SimpleParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(SimpleParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(SimpleParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(SimpleParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(SimpleParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(SimpleParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(SimpleParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(SimpleParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(SimpleParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(SimpleParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(SimpleParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(SimpleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(SimpleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(SimpleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(SimpleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(SimpleParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(SimpleParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(SimpleParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(SimpleParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(SimpleParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(SimpleParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(SimpleParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(SimpleParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(SimpleParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(SimpleParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(SimpleParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(SimpleParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(SimpleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(SimpleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(SimpleParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(SimpleParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(SimpleParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(SimpleParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(SimpleParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(SimpleParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(SimpleParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(SimpleParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(SimpleParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(SimpleParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(SimpleParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(SimpleParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SimpleParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SimpleParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(SimpleParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(SimpleParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(SimpleParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(SimpleParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SimpleParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SimpleParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(SimpleParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(SimpleParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(SimpleParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(SimpleParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(SimpleParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(SimpleParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(SimpleParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(SimpleParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(SimpleParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(SimpleParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(SimpleParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(SimpleParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(SimpleParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(SimpleParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(SimpleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(SimpleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(SimpleParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(SimpleParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(SimpleParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(SimpleParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(SimpleParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(SimpleParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(SimpleParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(SimpleParser.ArgumentsContext ctx);
}