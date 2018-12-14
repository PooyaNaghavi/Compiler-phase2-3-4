// Generated from /home/milad/Desktop/Compiler-phase3/main/Smoola.g4 by ANTLR 4.7

    import ast.*;
    import ast.node.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.node.statement.*;
    import ast.node.expression.Value.*;
    import ast.Type.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;
    import symbolTable.*;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.HashMap;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmoolaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, CONST_NUM=41, CONST_STR=42, NL=43, ID=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_statements = 5, RULE_statement = 6, RULE_statementBlock = 7, 
		RULE_statementCondition = 8, RULE_statementLoop = 9, RULE_statementWrite = 10, 
		RULE_statementAssignment = 11, RULE_expression = 12, RULE_expressionAssignment = 13, 
		RULE_expressionOr = 14, RULE_expressionOrTemp = 15, RULE_expressionAnd = 16, 
		RULE_expressionAndTemp = 17, RULE_expressionEq = 18, RULE_expressionEqTemp = 19, 
		RULE_expressionCmp = 20, RULE_expressionCmpTemp = 21, RULE_expressionAdd = 22, 
		RULE_expressionAddTemp = 23, RULE_expressionMult = 24, RULE_expressionMultTemp = 25, 
		RULE_expressionUnary = 26, RULE_expressionMem = 27, RULE_expressionMemTemp = 28, 
		RULE_expressionMethods = 29, RULE_expressionMethodsTemp = 30, RULE_expressionOther = 31, 
		RULE_type = 32;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"statements", "statement", "statementBlock", "statementCondition", "statementLoop", 
		"statementWrite", "statementAssignment", "expression", "expressionAssignment", 
		"expressionOr", "expressionOrTemp", "expressionAnd", "expressionAndTemp", 
		"expressionEq", "expressionEqTemp", "expressionCmp", "expressionCmpTemp", 
		"expressionAdd", "expressionAddTemp", "expressionMult", "expressionMultTemp", 
		"expressionUnary", "expressionMem", "expressionMemTemp", "expressionMethods", 
		"expressionMethodsTemp", "expressionOther", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'def'", "'('", "')'", "':'", "'int'", "'return'", 
		"';'", "'}'", "'extends'", "'var'", "','", "'if'", "'then'", "'else'", 
		"'while'", "'writeln('", "'='", "'||'", "'&&'", "'=='", "'<>'", "'<'", 
		"'>'", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'length'", 
		"'new '", "'this'", "'true'", "'false'", "'boolean'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "CONST_NUM", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smoola.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmoolaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainClassContext main_class;
		public ClassDeclarationContext class_dec;
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((ProgramContext)_localctx).main_class = mainClass();
			Program syn_program = new Program(); syn_program.setMainClass(((ProgramContext)_localctx).main_class.syn_main_class); 
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(68);
				((ProgramContext)_localctx).class_dec = classDeclaration();
				syn_program.addClass(((ProgramContext)_localctx).class_dec.syn_class_declaration); 
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			          SymbolTable.push(new SymbolTable());
			          SymbolTable.error = false;
			          SymbolTable.has_error = true;
			          SymbolTable.path1_error = false;
			          SymbolTable.path2_error = true;
			          SymbolTable.path3_error = true;
			          SymbolTable.path4_error = true;
			        
			setState(77);
			match(EOF);

			          Visitor visitor = new VisitorImpl();
			          syn_program.accept(visitor);
			          SymbolTable.path1_error = true;
			          SymbolTable.path2_error = false;
			          syn_program.accept(visitor);
			          SymbolTable.path2_error = true;
			          SymbolTable.path3_error = false;
			          syn_program.accept(visitor);
			          SymbolTable.path3_error = true;
			          SymbolTable.path4_error = false;
			          //syn_program.accept(visitor);
			          Visitor_path4 path4 = new Visitor_path4();
			          syn_program.accept(path4);
			          SymbolTable.path4_error = true;
			          if(SymbolTable.error == false){
			              SymbolTable.has_error = false;
			          }
			          if(SymbolTable.has_error == false)
			            syn_program.accept(visitor);
			          else{
			              HashMap<Integer, String> errors = visitor.getErrors();
			              ArrayList<Integer> keys = new ArrayList(errors.keySet());
			              Collections.sort(keys);
			              for (Integer i : keys) {
			                  System.out.println("Line:" + i + errors.get(i));
			              }
			          }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public ClassDeclaration syn_main_class;
		public Token class_name;
		public Token method_name;
		public StatementsContext stms;
		public ExpressionContext return_exp;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMainClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitMainClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(81);
			((MainClassContext)_localctx).class_name = match(ID);
			ClassDeclaration main_class = new ClassDeclaration(new Identifier((((MainClassContext)_localctx).class_name!=null?((MainClassContext)_localctx).class_name.getText():null), ((MainClassContext)_localctx).class_name.getLine())); main_class.set_line_num(((MainClassContext)_localctx).class_name.getLine());
			setState(83);
			match(T__1);
			setState(84);
			match(T__2);
			setState(85);
			((MainClassContext)_localctx).method_name = match(ID);
			setState(86);
			match(T__3);
			setState(87);
			match(T__4);
			setState(88);
			match(T__5);
			setState(89);
			match(T__6);
			MethodDeclaration method_dec = new MethodDeclaration(new Identifier((((MainClassContext)_localctx).method_name!=null?((MainClassContext)_localctx).method_name.getText():null), ((MainClassContext)_localctx).method_name.getLine())); method_dec.set_line_num(((MainClassContext)_localctx).method_name.getLine());
			method_dec.setReturnType(new IntType()); 
			setState(92);
			match(T__1);
			setState(93);
			((MainClassContext)_localctx).stms = statements();
			method_dec.addStatements(((MainClassContext)_localctx).stms.syn_statements); 
			setState(95);
			match(T__7);
			setState(96);
			((MainClassContext)_localctx).return_exp = expression();
			method_dec.setReturnValue(((MainClassContext)_localctx).return_exp.syn_expression); 
			setState(98);
			match(T__8);
			setState(99);
			match(T__9);
			setState(100);
			match(T__9);
			main_class.addMethodDeclaration(method_dec); ((MainClassContext)_localctx).syn_main_class =  main_class;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration syn_class_declaration;
		public Token class_name;
		public Token parent_class_name;
		public VarDeclarationContext var_dec;
		public MethodDeclarationContext method_dec;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(104);
			((ClassDeclarationContext)_localctx).class_name = match(ID);
			ClassDeclaration class_dec = new ClassDeclaration(new Identifier((((ClassDeclarationContext)_localctx).class_name!=null?((ClassDeclarationContext)_localctx).class_name.getText():null), ((ClassDeclarationContext)_localctx).class_name.getLine())); class_dec.set_line_num(((ClassDeclarationContext)_localctx).class_name.getLine());
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(106);
				match(T__10);
				setState(107);
				((ClassDeclarationContext)_localctx).parent_class_name = match(ID);
				class_dec.setParentName(new Identifier((((ClassDeclarationContext)_localctx).parent_class_name!=null?((ClassDeclarationContext)_localctx).parent_class_name.getText():null), ((ClassDeclarationContext)_localctx).parent_class_name.getLine())); class_dec.set_line_num(((ClassDeclarationContext)_localctx).parent_class_name.getLine()); 
				}
			}

			setState(111);
			match(T__1);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(112);
				((ClassDeclarationContext)_localctx).var_dec = varDeclaration();
				class_dec.addVarDeclaration(((ClassDeclarationContext)_localctx).var_dec.syn_var_declaration); 
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(120);
				((ClassDeclarationContext)_localctx).method_dec = methodDeclaration();
				class_dec.addMethodDeclaration(((ClassDeclarationContext)_localctx).method_dec.syn_method_declaration); 
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__9);
			((ClassDeclarationContext)_localctx).syn_class_declaration =  class_dec; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration syn_var_declaration;
		public Token var_name;
		public TypeContext var_type;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__11);
			setState(132);
			((VarDeclarationContext)_localctx).var_name = match(ID);
			setState(133);
			match(T__5);
			setState(134);
			((VarDeclarationContext)_localctx).var_type = type();
			setState(135);
			match(T__8);
			((VarDeclarationContext)_localctx).syn_var_declaration =  new VarDeclaration(new Identifier((((VarDeclarationContext)_localctx).var_name!=null?((VarDeclarationContext)_localctx).var_name.getText():null), ((VarDeclarationContext)_localctx).var_name.getLine()), ((VarDeclarationContext)_localctx).var_type.syn_type); _localctx.syn_var_declaration.set_line_num(((VarDeclarationContext)_localctx).var_name.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclaration syn_method_declaration;
		public Token method_name;
		public Token var_name1;
		public TypeContext var_type1;
		public Token var_name2;
		public TypeContext var_type2;
		public TypeContext return_type;
		public VarDeclarationContext var_dec;
		public StatementsContext stms;
		public ExpressionContext return_exp;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__2);
			setState(139);
			((MethodDeclarationContext)_localctx).method_name = match(ID);
			MethodDeclaration method_dec = new MethodDeclaration(new Identifier((((MethodDeclarationContext)_localctx).method_name!=null?((MethodDeclarationContext)_localctx).method_name.getText():null), ((MethodDeclarationContext)_localctx).method_name.getLine())); method_dec.set_line_num(((MethodDeclarationContext)_localctx).method_name.getLine()); 
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(141);
				match(T__3);
				setState(142);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(143);
				match(T__3);
				setState(144);
				((MethodDeclarationContext)_localctx).var_name1 = match(ID);
				setState(145);
				match(T__5);
				setState(146);
				((MethodDeclarationContext)_localctx).var_type1 = type();
				VarDeclaration var1 = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).var_name1!=null?((MethodDeclarationContext)_localctx).var_name1.getText():null), ((MethodDeclarationContext)_localctx).var_name1.getLine()), ((MethodDeclarationContext)_localctx).var_type1.syn_type); method_dec.addArg(var1); var1.set_line_num(((MethodDeclarationContext)_localctx).var_name1.getLine());
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(148);
					match(T__12);
					setState(149);
					((MethodDeclarationContext)_localctx).var_name2 = match(ID);
					setState(150);
					match(T__5);
					setState(151);
					((MethodDeclarationContext)_localctx).var_type2 = type();
					VarDeclaration var2 = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).var_name2!=null?((MethodDeclarationContext)_localctx).var_name2.getText():null), ((MethodDeclarationContext)_localctx).var_name2.getLine()), ((MethodDeclarationContext)_localctx).var_type2.syn_type); method_dec.addArg(var2); var2.set_line_num(((MethodDeclarationContext)_localctx).var_name2.getLine());
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				match(T__4);
				}
				}
				break;
			}
			setState(163);
			match(T__5);
			setState(164);
			((MethodDeclarationContext)_localctx).return_type = type();
			method_dec.setReturnType(((MethodDeclarationContext)_localctx).return_type.syn_type); 
			setState(166);
			match(T__1);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(167);
				((MethodDeclarationContext)_localctx).var_dec = varDeclaration();
				method_dec.addLocalVar(((MethodDeclarationContext)_localctx).var_dec.syn_var_declaration); 
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			((MethodDeclarationContext)_localctx).stms = statements();
			method_dec.addStatements(((MethodDeclarationContext)_localctx).stms.syn_statements); 
			setState(177);
			match(T__7);
			setState(178);
			((MethodDeclarationContext)_localctx).return_exp = expression();
			method_dec.setReturnValue(((MethodDeclarationContext)_localctx).return_exp.syn_expression); ((MethodDeclarationContext)_localctx).syn_method_declaration =  method_dec; 
			setState(180);
			match(T__8);
			setState(181);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public ArrayList<Statement> syn_statements;
		public StatementContext stm;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((StatementsContext)_localctx).syn_statements =  new ArrayList<Statement>();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(184);
				((StatementsContext)_localctx).stm = statement();
				_localctx.syn_statements.add(((StatementsContext)_localctx).stm.syn_statement); 
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement syn_statement;
		public StatementBlockContext stm_block;
		public StatementConditionContext stm_condition;
		public StatementLoopContext stm_loop;
		public StatementWriteContext stm_write;
		public StatementAssignmentContext stm_assignment;
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatementConditionContext statementCondition() {
			return getRuleContext(StatementConditionContext.class,0);
		}
		public StatementLoopContext statementLoop() {
			return getRuleContext(StatementLoopContext.class,0);
		}
		public StatementWriteContext statementWrite() {
			return getRuleContext(StatementWriteContext.class,0);
		}
		public StatementAssignmentContext statementAssignment() {
			return getRuleContext(StatementAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				((StatementContext)_localctx).stm_block = statementBlock();
				((StatementContext)_localctx).syn_statement =  ((StatementContext)_localctx).stm_block.syn_statement_block;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				((StatementContext)_localctx).stm_condition = statementCondition();
				((StatementContext)_localctx).syn_statement =  ((StatementContext)_localctx).stm_condition.syn_statement_condition;
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				((StatementContext)_localctx).stm_loop = statementLoop();
				((StatementContext)_localctx).syn_statement =  ((StatementContext)_localctx).stm_loop.syn_statement_loop;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				((StatementContext)_localctx).stm_write = statementWrite();
				((StatementContext)_localctx).syn_statement =  ((StatementContext)_localctx).stm_write.syn_statement_write;
				}
				break;
			case T__3:
			case T__26:
			case T__29:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				((StatementContext)_localctx).stm_assignment = statementAssignment();
				((StatementContext)_localctx).syn_statement =  ((StatementContext)_localctx).stm_assignment.syn_statement_assign;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public Block syn_statement_block;
		public StatementsContext stms;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__1);
			setState(210);
			((StatementBlockContext)_localctx).stms = statements();
			setState(211);
			match(T__9);
			((StatementBlockContext)_localctx).syn_statement_block =  new Block(((StatementBlockContext)_localctx).stms.syn_statements);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementConditionContext extends ParserRuleContext {
		public Conditional syn_statement_condition;
		public ExpressionContext exp;
		public StatementContext stm1;
		public StatementContext stm2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatementCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementConditionContext statementCondition() throws RecognitionException {
		StatementConditionContext _localctx = new StatementConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__13);
			setState(215);
			match(T__3);
			setState(216);
			((StatementConditionContext)_localctx).exp = expression();
			setState(217);
			match(T__4);
			setState(218);
			match(T__14);
			setState(219);
			((StatementConditionContext)_localctx).stm1 = statement();
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(220);
				match(T__15);
				setState(221);
				((StatementConditionContext)_localctx).stm2 = statement();
				}
				break;
			}
			((StatementConditionContext)_localctx).syn_statement_condition =  new Conditional(((StatementConditionContext)_localctx).exp.syn_expression, ((StatementConditionContext)_localctx).stm1.syn_statement, ((StatementConditionContext)_localctx).stm2.syn_statement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementLoopContext extends ParserRuleContext {
		public While syn_statement_loop;
		public ExpressionContext exp;
		public StatementContext stm;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatementLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementLoopContext statementLoop() throws RecognitionException {
		StatementLoopContext _localctx = new StatementLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__16);
			setState(227);
			match(T__3);
			setState(228);
			((StatementLoopContext)_localctx).exp = expression();
			setState(229);
			match(T__4);
			setState(230);
			((StatementLoopContext)_localctx).stm = statement();
			((StatementLoopContext)_localctx).syn_statement_loop =  new While(((StatementLoopContext)_localctx).exp.syn_expression, ((StatementLoopContext)_localctx).stm.syn_statement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWriteContext extends ParserRuleContext {
		public Write syn_statement_write;
		public Token write_name;
		public ExpressionContext exp;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatementWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementWriteContext statementWrite() throws RecognitionException {
		StatementWriteContext _localctx = new StatementWriteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			((StatementWriteContext)_localctx).write_name = match(T__17);
			setState(234);
			((StatementWriteContext)_localctx).exp = expression();
			Write w = new Write(((StatementWriteContext)_localctx).exp.syn_expression); w.set_line_num(((StatementWriteContext)_localctx).write_name.getLine()); ((StatementWriteContext)_localctx).syn_statement_write =  w;
			setState(236);
			match(T__4);
			setState(237);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementAssignmentContext extends ParserRuleContext {
		public Assign syn_statement_assign;
		public ExpressionContext exp;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitStatementAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementAssignmentContext statementAssignment() throws RecognitionException {
		StatementAssignmentContext _localctx = new StatementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((StatementAssignmentContext)_localctx).exp = expression();

			          if(((StatementAssignmentContext)_localctx).exp.syn_expression == null)
			              ((StatementAssignmentContext)_localctx).syn_statement_assign =  ((StatementAssignmentContext)_localctx).exp.syn_expression_assign;
			        
			setState(241);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Assign syn_expression_assign;
		public Expression syn_expression;
		public ExpressionAssignmentContext exp_assign;
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			((ExpressionContext)_localctx).exp_assign = expressionAssignment();

			        if(((ExpressionContext)_localctx).exp_assign.syn_assign_right == null)
			            ((ExpressionContext)_localctx).syn_expression =  ((ExpressionContext)_localctx).exp_assign.syn_expression_assignment;
			        else
			            ((ExpressionContext)_localctx).syn_expression_assign =  new Assign(((ExpressionContext)_localctx).exp_assign.syn_assign_left, ((ExpressionContext)_localctx).exp_assign.syn_assign_right);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAssignmentContext extends ParserRuleContext {
		public Expression syn_assign_left;
		public Expression syn_assign_right;
		public Expression syn_expression_assignment;
		public String syn_assign_op;
		public ExpressionOrContext exp_or;
		public Token assign_op;
		public ExpressionAssignmentContext exp_assign;
		public ExpressionOrContext expressionOr() {
			return getRuleContext(ExpressionOrContext.class,0);
		}
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionAssignmentContext expressionAssignment() throws RecognitionException {
		ExpressionAssignmentContext _localctx = new ExpressionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionAssignment);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				((ExpressionAssignmentContext)_localctx).exp_or = expressionOr();
				setState(247);
				((ExpressionAssignmentContext)_localctx).assign_op = match(T__18);
				setState(248);
				((ExpressionAssignmentContext)_localctx).exp_assign = expressionAssignment();

				          {
				              ((ExpressionAssignmentContext)_localctx).syn_assign_op =  (((ExpressionAssignmentContext)_localctx).assign_op!=null?((ExpressionAssignmentContext)_localctx).assign_op.getText():null);
				              ((ExpressionAssignmentContext)_localctx).syn_assign_left =  ((ExpressionAssignmentContext)_localctx).exp_or.syn_expression_or;
				              ((ExpressionAssignmentContext)_localctx).syn_assign_right =  ((ExpressionAssignmentContext)_localctx).exp_assign.syn_expression_assignment;
				              ((ExpressionAssignmentContext)_localctx).syn_expression_assignment =  new BinaryExpression(((ExpressionAssignmentContext)_localctx).exp_or.syn_expression_or, ((ExpressionAssignmentContext)_localctx).exp_assign.syn_expression_assignment, BinaryOperator.assign);
				          }
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				((ExpressionAssignmentContext)_localctx).exp_or = expressionOr();
				((ExpressionAssignmentContext)_localctx).syn_expression_assignment =  ((ExpressionAssignmentContext)_localctx).exp_or.syn_expression_or; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrContext extends ParserRuleContext {
		public Expression syn_expression_or;
		public ExpressionAndContext exp_and;
		public ExpressionOrTempContext exp_or_temp;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionOrContext expressionOr() throws RecognitionException {
		ExpressionOrContext _localctx = new ExpressionOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			((ExpressionOrContext)_localctx).exp_and = expressionAnd();
			setState(257);
			((ExpressionOrContext)_localctx).exp_or_temp = expressionOrTemp();


			        if(((ExpressionOrContext)_localctx).exp_or_temp.syn_expression_or_temp == null)
			            ((ExpressionOrContext)_localctx).syn_expression_or =  ((ExpressionOrContext)_localctx).exp_and.syn_expression_and;
			        else
			            ((ExpressionOrContext)_localctx).syn_expression_or =  new BinaryExpression(((ExpressionOrContext)_localctx).exp_and.syn_expression_and, ((ExpressionOrContext)_localctx).exp_or_temp.syn_expression_or_temp, BinaryOperator.or);

			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrTempContext extends ParserRuleContext {
		public Expression syn_expression_or_temp;
		public String syn_or_op;
		public Token or_op;
		public ExpressionAndContext exp_and;
		public ExpressionOrTempContext exp_or_temp;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOrTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOrTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionOrTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionOrTempContext expressionOrTemp() throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionOrTemp);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				((ExpressionOrTempContext)_localctx).or_op = match(T__19);
				setState(261);
				((ExpressionOrTempContext)_localctx).exp_and = expressionAnd();
				setState(262);
				((ExpressionOrTempContext)_localctx).exp_or_temp = expressionOrTemp();

				            if(((ExpressionOrTempContext)_localctx).exp_or_temp.syn_expression_or_temp == null) {
				                ((ExpressionOrTempContext)_localctx).syn_expression_or_temp =  ((ExpressionOrTempContext)_localctx).exp_and.syn_expression_and;
				                ((ExpressionOrTempContext)_localctx).syn_or_op =  (((ExpressionOrTempContext)_localctx).or_op!=null?((ExpressionOrTempContext)_localctx).or_op.getText():null);
				            }
				            else {
				                ((ExpressionOrTempContext)_localctx).syn_or_op =  (((ExpressionOrTempContext)_localctx).or_op!=null?((ExpressionOrTempContext)_localctx).or_op.getText():null);
				                ((ExpressionOrTempContext)_localctx).syn_expression_or_temp =  new BinaryExpression(((ExpressionOrTempContext)_localctx).exp_and.syn_expression_and, ((ExpressionOrTempContext)_localctx).exp_or_temp.syn_expression_or_temp, BinaryOperator.or );
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndContext extends ParserRuleContext {
		public Expression syn_expression_and;
		public ExpressionEqContext exp_eq;
		public ExpressionAndTempContext exp_and_temp;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionAndContext expressionAnd() throws RecognitionException {
		ExpressionAndContext _localctx = new ExpressionAndContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			((ExpressionAndContext)_localctx).exp_eq = expressionEq();
			setState(269);
			((ExpressionAndContext)_localctx).exp_and_temp = expressionAndTemp();

			        if(((ExpressionAndContext)_localctx).exp_and_temp.syn_expression_and_temp == null)
			            ((ExpressionAndContext)_localctx).syn_expression_and =  ((ExpressionAndContext)_localctx).exp_eq.syn_expression_eq;
			        else
			            ((ExpressionAndContext)_localctx).syn_expression_and =  new BinaryExpression(((ExpressionAndContext)_localctx).exp_eq.syn_expression_eq, ((ExpressionAndContext)_localctx).exp_and_temp.syn_expression_and_temp, BinaryOperator.and);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndTempContext extends ParserRuleContext {
		public Expression syn_expression_and_temp;
		public String syn_and_op;
		public Token and_op;
		public ExpressionEqContext exp_eq;
		public ExpressionAndTempContext exp_and_temp;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAndTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAndTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionAndTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionAndTempContext expressionAndTemp() throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionAndTemp);
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				((ExpressionAndTempContext)_localctx).and_op = match(T__20);
				setState(273);
				((ExpressionAndTempContext)_localctx).exp_eq = expressionEq();
				setState(274);
				((ExpressionAndTempContext)_localctx).exp_and_temp = expressionAndTemp();

				          if(((ExpressionAndTempContext)_localctx).exp_and_temp.syn_expression_and_temp == null)
				          {
				              ((ExpressionAndTempContext)_localctx).syn_expression_and_temp =  ((ExpressionAndTempContext)_localctx).exp_eq.syn_expression_eq;
				              ((ExpressionAndTempContext)_localctx).syn_and_op =  (((ExpressionAndTempContext)_localctx).and_op!=null?((ExpressionAndTempContext)_localctx).and_op.getText():null);
				          }
				          else
				          {
				              ((ExpressionAndTempContext)_localctx).syn_and_op =  (((ExpressionAndTempContext)_localctx).and_op!=null?((ExpressionAndTempContext)_localctx).and_op.getText():null);
				              ((ExpressionAndTempContext)_localctx).syn_expression_and_temp =  new BinaryExpression(((ExpressionAndTempContext)_localctx).exp_eq.syn_expression_eq, ((ExpressionAndTempContext)_localctx).exp_and_temp.syn_expression_and_temp, BinaryOperator.and );
				          }
				      
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqContext extends ParserRuleContext {
		public Expression syn_expression_eq;
		public ExpressionCmpContext exp_cmp;
		public ExpressionEqTempContext exp_eq_temp;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionEqContext expressionEq() throws RecognitionException {
		ExpressionEqContext _localctx = new ExpressionEqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionEq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((ExpressionEqContext)_localctx).exp_cmp = expressionCmp();
			setState(281);
			((ExpressionEqContext)_localctx).exp_eq_temp = expressionEqTemp();

			       if(((ExpressionEqContext)_localctx).exp_eq_temp.syn_expression_eq_temp == null)
			          ((ExpressionEqContext)_localctx).syn_expression_eq =  ((ExpressionEqContext)_localctx).exp_cmp.syn_expression_cmp;
			      else {
			           if(((ExpressionEqContext)_localctx).exp_eq_temp.syn_eq_op.equals("=="))
			               ((ExpressionEqContext)_localctx).syn_expression_eq =  new BinaryExpression(((ExpressionEqContext)_localctx).exp_cmp.syn_expression_cmp, ((ExpressionEqContext)_localctx).exp_eq_temp.syn_expression_eq_temp, BinaryOperator.eq);
			           else if(((ExpressionEqContext)_localctx).exp_eq_temp.syn_eq_op.equals("<>"))
			               ((ExpressionEqContext)_localctx).syn_expression_eq =  new BinaryExpression(((ExpressionEqContext)_localctx).exp_cmp.syn_expression_cmp, ((ExpressionEqContext)_localctx).exp_eq_temp.syn_expression_eq_temp, BinaryOperator.neq);
			       }
			     
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqTempContext extends ParserRuleContext {
		public Expression syn_expression_eq_temp;
		public String syn_eq_op;
		public Token op_eq;
		public ExpressionCmpContext exp_cmp;
		public ExpressionEqTempContext exp_eq_temp;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEqTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEqTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionEqTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionEqTempContext expressionEqTemp() throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionEqTemp);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				((ExpressionEqTempContext)_localctx).op_eq = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((ExpressionEqTempContext)_localctx).op_eq = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(285);
				((ExpressionEqTempContext)_localctx).exp_cmp = expressionCmp();
				setState(286);
				((ExpressionEqTempContext)_localctx).exp_eq_temp = expressionEqTemp();

				          if(((ExpressionEqTempContext)_localctx).exp_eq_temp.syn_expression_eq_temp == null) {
				              ((ExpressionEqTempContext)_localctx).syn_expression_eq_temp =  ((ExpressionEqTempContext)_localctx).exp_cmp.syn_expression_cmp;
				              ((ExpressionEqTempContext)_localctx).syn_eq_op =  (((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null);
				              /* if((((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null).equals(BinaryOperator.eq))
				                  ((ExpressionEqTempContext)_localctx).syn_eq_op =  BinaryOperator.eq;
				              else if((((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null).equals(BinaryOperator.neq))
				                  ((ExpressionEqTempContext)_localctx).syn_eq_op =  BinaryOperator.neq; */
				          }
				          else {
				              ((ExpressionEqTempContext)_localctx).syn_eq_op =  (((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null);
				              if(((ExpressionEqTempContext)_localctx).exp_eq_temp.syn_eq_op.equals("==")){
				              //if((((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null).equals(BinaryOperator.eq)){
				                  //((ExpressionEqTempContext)_localctx).syn_eq_op =  BinaryOperator.eq;
				                  ((ExpressionEqTempContext)_localctx).syn_expression_eq_temp =  new BinaryExpression(((ExpressionEqTempContext)_localctx).exp_cmp.syn_expression_cmp, ((ExpressionEqTempContext)_localctx).exp_eq_temp.syn_expression_eq_temp, BinaryOperator.eq );
				              }
				              else if(((ExpressionEqTempContext)_localctx).exp_eq_temp.syn_eq_op.equals("<>")){
				              //else if((((ExpressionEqTempContext)_localctx).op_eq!=null?((ExpressionEqTempContext)_localctx).op_eq.getText():null).equals(BinaryOperator.neq)){
				                //  ((ExpressionEqTempContext)_localctx).syn_eq_op =  BinaryOperator.neq;
				                  ((ExpressionEqTempContext)_localctx).syn_expression_eq_temp =  new BinaryExpression(((ExpressionEqTempContext)_localctx).exp_cmp.syn_expression_cmp, ((ExpressionEqTempContext)_localctx).exp_eq_temp.syn_expression_eq_temp, BinaryOperator.neq );
				              }
				          }
				      
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpContext extends ParserRuleContext {
		public Expression syn_expression_cmp;
		public ExpressionAddContext exp_add;
		public ExpressionCmpTempContext exp_cmp_temp;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionCmp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionCmpContext expressionCmp() throws RecognitionException {
		ExpressionCmpContext _localctx = new ExpressionCmpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressionCmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			((ExpressionCmpContext)_localctx).exp_add = expressionAdd();
			setState(293);
			((ExpressionCmpContext)_localctx).exp_cmp_temp = expressionCmpTemp();

			        if(((ExpressionCmpContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp == null)
			            ((ExpressionCmpContext)_localctx).syn_expression_cmp =  ((ExpressionCmpContext)_localctx).exp_add.syn_expression_add;
			        else {
			            if(((ExpressionCmpContext)_localctx).exp_cmp_temp.syn_cmp_op.equals(">"))
			                ((ExpressionCmpContext)_localctx).syn_expression_cmp =  new BinaryExpression(((ExpressionCmpContext)_localctx).exp_add.syn_expression_add, ((ExpressionCmpContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.gt);
			            else if(((ExpressionCmpContext)_localctx).exp_cmp_temp.syn_cmp_op.equals("<"))
			                ((ExpressionCmpContext)_localctx).syn_expression_cmp =  new BinaryExpression(((ExpressionCmpContext)_localctx).exp_add.syn_expression_add, ((ExpressionCmpContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.lt);
			        }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpTempContext extends ParserRuleContext {
		public Expression syn_expression_cmp_temp;
		public String syn_cmp_op;
		public Token op_cmp;
		public ExpressionAddContext exp_add;
		public ExpressionCmpTempContext exp_cmp_temp;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmpTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmpTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionCmpTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionCmpTempContext expressionCmpTemp() throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressionCmpTemp);
		int _la;
		try {
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((ExpressionCmpTempContext)_localctx).op_cmp = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
					((ExpressionCmpTempContext)_localctx).op_cmp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(297);
				((ExpressionCmpTempContext)_localctx).exp_add = expressionAdd();
				setState(298);
				((ExpressionCmpTempContext)_localctx).exp_cmp_temp = expressionCmpTemp();

				          if(((ExpressionCmpTempContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp == null) {
				              ((ExpressionCmpTempContext)_localctx).syn_expression_cmp_temp =  ((ExpressionCmpTempContext)_localctx).exp_add.syn_expression_add;
				              ((ExpressionCmpTempContext)_localctx).syn_cmp_op =  (((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null);
				              /* if((((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null).equals(BinaryOperator.gt))
				                  ((ExpressionCmpTempContext)_localctx).syn_cmp_op =  BinaryOperator.gt;
				              else if((((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null).equals(BinaryOperator.lt))
				                  ((ExpressionCmpTempContext)_localctx).syn_cmp_op =  BinaryOperator.lt; */
				          }
				          else {
				                ((ExpressionCmpTempContext)_localctx).syn_cmp_op =  (((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null);
				                if(((ExpressionCmpTempContext)_localctx).exp_cmp_temp.syn_cmp_op.equals(">")){
				              //if((((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null).equals(BinaryOperator.gt)){
				                  //((ExpressionCmpTempContext)_localctx).syn_cmp_op =  BinaryOperator.gt;
				                  ((ExpressionCmpTempContext)_localctx).syn_expression_cmp_temp =  new BinaryExpression(((ExpressionCmpTempContext)_localctx).exp_add.syn_expression_add, ((ExpressionCmpTempContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.gt );
				              }
				              else if(((ExpressionCmpTempContext)_localctx).exp_cmp_temp.syn_cmp_op.equals("<")){
				              //else if((((ExpressionCmpTempContext)_localctx).op_cmp!=null?((ExpressionCmpTempContext)_localctx).op_cmp.getText():null).equals(BinaryOperator.lt)){
				                  //((ExpressionCmpTempContext)_localctx).syn_cmp_op =  BinaryOperator.lt;
				                  ((ExpressionCmpTempContext)_localctx).syn_expression_cmp_temp =  new BinaryExpression(((ExpressionCmpTempContext)_localctx).exp_add.syn_expression_add, ((ExpressionCmpTempContext)_localctx).exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.lt );
				              }
				          }
				      
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddContext extends ParserRuleContext {
		public Expression syn_expression_add;
		public ExpressionMultContext exp_mult;
		public ExpressionAddTempContext exp_add_temp;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionAddContext expressionAdd() throws RecognitionException {
		ExpressionAddContext _localctx = new ExpressionAddContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			((ExpressionAddContext)_localctx).exp_mult = expressionMult();
			setState(305);
			((ExpressionAddContext)_localctx).exp_add_temp = expressionAddTemp();

			          if(((ExpressionAddContext)_localctx).exp_add_temp.syn_expression_add_temp == null)
			                ((ExpressionAddContext)_localctx).syn_expression_add =  ((ExpressionAddContext)_localctx).exp_mult.syn_expression_mult;
			          else {
			              if(((ExpressionAddContext)_localctx).exp_add_temp.syn_add_op.equals("+"))
			                  ((ExpressionAddContext)_localctx).syn_expression_add =  new BinaryExpression(((ExpressionAddContext)_localctx).exp_mult.syn_expression_mult, ((ExpressionAddContext)_localctx).exp_add_temp.syn_expression_add_temp, BinaryOperator.add);
			              else if(((ExpressionAddContext)_localctx).exp_add_temp.syn_add_op.equals("-"))
			                  ((ExpressionAddContext)_localctx).syn_expression_add =  new BinaryExpression(((ExpressionAddContext)_localctx).exp_mult.syn_expression_mult, ((ExpressionAddContext)_localctx).exp_add_temp.syn_expression_add_temp, BinaryOperator.sub);
			          }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddTempContext extends ParserRuleContext {
		public Expression syn_expression_add_temp;
		public String syn_add_op;
		public Token op_add;
		public ExpressionMultContext exp_mult;
		public ExpressionAddTempContext exp_temp_add;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAddTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAddTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionAddTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionAddTempContext expressionAddTemp() throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionAddTemp);
		int _la;
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				((ExpressionAddTempContext)_localctx).op_add = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
					((ExpressionAddTempContext)_localctx).op_add = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(309);
				((ExpressionAddTempContext)_localctx).exp_mult = expressionMult();
				setState(310);
				((ExpressionAddTempContext)_localctx).exp_temp_add = expressionAddTemp();

				          if(((ExpressionAddTempContext)_localctx).exp_temp_add.syn_expression_add_temp == null) {
				              ((ExpressionAddTempContext)_localctx).syn_expression_add_temp =  ((ExpressionAddTempContext)_localctx).exp_mult.syn_expression_mult;
				              ((ExpressionAddTempContext)_localctx).syn_add_op =  (((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null);
				              /* if((((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null).equals(BinaryOperator.add))
				                  ((ExpressionAddTempContext)_localctx).syn_add_op =  BinaryOperator.add;
				              else if((((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null).equals(BinaryOperator.sub))
				                  ((ExpressionAddTempContext)_localctx).syn_add_op =  BinaryOperator.sub; */
				          }
				          else {
				              ((ExpressionAddTempContext)_localctx).syn_add_op =  (((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null);
				              if(((ExpressionAddTempContext)_localctx).exp_temp_add.syn_add_op.equals("+")){
				              //if((((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null).equals(BinaryOperator.add)){
				                  //((ExpressionAddTempContext)_localctx).syn_add_op =  BinaryOperator.add;
				                  ((ExpressionAddTempContext)_localctx).syn_expression_add_temp =  new BinaryExpression(((ExpressionAddTempContext)_localctx).exp_mult.syn_expression_mult, ((ExpressionAddTempContext)_localctx).exp_temp_add.syn_expression_add_temp, BinaryOperator.add);
				              }
				              else if(((ExpressionAddTempContext)_localctx).exp_temp_add.syn_add_op.equals("-")){
				              //else if((((ExpressionAddTempContext)_localctx).op_add!=null?((ExpressionAddTempContext)_localctx).op_add.getText():null).equals(BinaryOperator.sub)){
				                  //((ExpressionAddTempContext)_localctx).syn_add_op =  BinaryOperator.sub;
				                  ((ExpressionAddTempContext)_localctx).syn_expression_add_temp =  new BinaryExpression(((ExpressionAddTempContext)_localctx).exp_mult.syn_expression_mult, ((ExpressionAddTempContext)_localctx).exp_temp_add.syn_expression_add_temp, BinaryOperator.sub);
				              }
				          }
				      
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultContext extends ParserRuleContext {
		public Expression syn_expression_mult;
		public ExpressionUnaryContext exp_unary;
		public ExpressionMultTempContext exp_mult_temp;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMultContext expressionMult() throws RecognitionException {
		ExpressionMultContext _localctx = new ExpressionMultContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionMult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			((ExpressionMultContext)_localctx).exp_unary = expressionUnary();
			setState(317);
			((ExpressionMultContext)_localctx).exp_mult_temp = expressionMultTemp();

			        if(((ExpressionMultContext)_localctx).exp_mult_temp.syn_expression_mult_temp == null)
			            ((ExpressionMultContext)_localctx).syn_expression_mult =  ((ExpressionMultContext)_localctx).exp_unary.syn_expression_unary;
			        else {
			          if(((ExpressionMultContext)_localctx).exp_mult_temp.syn_mult_op.equals("*"))
			              ((ExpressionMultContext)_localctx).syn_expression_mult =  new BinaryExpression(((ExpressionMultContext)_localctx).exp_unary.syn_expression_unary, ((ExpressionMultContext)_localctx).exp_mult_temp.syn_expression_mult_temp, BinaryOperator.mult );
			          else if(((ExpressionMultContext)_localctx).exp_mult_temp.syn_mult_op.equals("/"))
			              ((ExpressionMultContext)_localctx).syn_expression_mult =  new BinaryExpression(((ExpressionMultContext)_localctx).exp_unary.syn_expression_unary, ((ExpressionMultContext)_localctx).exp_mult_temp.syn_expression_mult_temp, BinaryOperator.div );
			        }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultTempContext extends ParserRuleContext {
		public Expression syn_expression_mult_temp;
		public String syn_mult_op;
		public Token op_mult;
		public ExpressionUnaryContext exp_unary;
		public ExpressionMultTempContext exp_mult_temp;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMultTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMultTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMultTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMultTempContext expressionMultTemp() throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressionMultTemp);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				((ExpressionMultTempContext)_localctx).op_mult = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
					((ExpressionMultTempContext)_localctx).op_mult = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(321);
				((ExpressionMultTempContext)_localctx).exp_unary = expressionUnary();
				setState(322);
				((ExpressionMultTempContext)_localctx).exp_mult_temp = expressionMultTemp();

				          if(((ExpressionMultTempContext)_localctx).exp_mult_temp.syn_expression_mult_temp == null) {
				              ((ExpressionMultTempContext)_localctx).syn_expression_mult_temp =  ((ExpressionMultTempContext)_localctx).exp_unary.syn_expression_unary;
				              ((ExpressionMultTempContext)_localctx).syn_mult_op =  (((ExpressionMultTempContext)_localctx).op_mult!=null?((ExpressionMultTempContext)_localctx).op_mult.getText():null);
				          }
				          else {
				              ((ExpressionMultTempContext)_localctx).syn_mult_op =  (((ExpressionMultTempContext)_localctx).op_mult!=null?((ExpressionMultTempContext)_localctx).op_mult.getText():null);
				              if(((ExpressionMultTempContext)_localctx).exp_mult_temp.syn_mult_op.equals("*")){
				              //if((((ExpressionMultTempContext)_localctx).op_mult!=null?((ExpressionMultTempContext)_localctx).op_mult.getText():null).equals(BinaryOperator.mult)){
				                  //((ExpressionMultTempContext)_localctx).syn_mult_op =  BinaryOperator.mult;
				                  ((ExpressionMultTempContext)_localctx).syn_expression_mult_temp =  new BinaryExpression(((ExpressionMultTempContext)_localctx).exp_unary.syn_expression_unary, ((ExpressionMultTempContext)_localctx).exp_mult_temp.syn_expression_mult_temp, BinaryOperator.mult);

				              }
				              else if(((ExpressionMultTempContext)_localctx).exp_mult_temp.syn_mult_op.equals("/")){
				              //else if((((ExpressionMultTempContext)_localctx).op_mult!=null?((ExpressionMultTempContext)_localctx).op_mult.getText():null).equals(BinaryOperator.div)){
				                //  ((ExpressionMultTempContext)_localctx).syn_mult_op =  BinaryOperator.div;
				                  ((ExpressionMultTempContext)_localctx).syn_expression_mult_temp =  new BinaryExpression(((ExpressionMultTempContext)_localctx).exp_unary.syn_expression_unary, ((ExpressionMultTempContext)_localctx).exp_mult_temp.syn_expression_mult_temp, BinaryOperator.div);
				              }
				          }
				      
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionUnaryContext extends ParserRuleContext {
		public Expression syn_expression_unary;
		public Token op_unary;
		public ExpressionUnaryContext exp_unary;
		public ExpressionMemContext exp_mem;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMemContext expressionMem() {
			return getRuleContext(ExpressionMemContext.class,0);
		}
		public ExpressionUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionUnaryContext expressionUnary() throws RecognitionException {
		ExpressionUnaryContext _localctx = new ExpressionUnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionUnary);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				((ExpressionUnaryContext)_localctx).op_unary = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__29) ) {
					((ExpressionUnaryContext)_localctx).op_unary = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(329);
				((ExpressionUnaryContext)_localctx).exp_unary = expressionUnary();

				        if((((ExpressionUnaryContext)_localctx).op_unary!=null?((ExpressionUnaryContext)_localctx).op_unary.getText():null).equals("!"))
				            ((ExpressionUnaryContext)_localctx).syn_expression_unary =  new UnaryExpression(UnaryOperator.not, ((ExpressionUnaryContext)_localctx).exp_unary.syn_expression_unary);
				        else if((((ExpressionUnaryContext)_localctx).op_unary!=null?((ExpressionUnaryContext)_localctx).op_unary.getText():null).equals("-"))
				            ((ExpressionUnaryContext)_localctx).syn_expression_unary =  new UnaryExpression(UnaryOperator.minus, ((ExpressionUnaryContext)_localctx).exp_unary.syn_expression_unary);
				      
				}
				break;
			case T__3:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				((ExpressionUnaryContext)_localctx).exp_mem = expressionMem();
				((ExpressionUnaryContext)_localctx).syn_expression_unary =  ((ExpressionUnaryContext)_localctx).exp_mem.syn_expression_mem; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemContext extends ParserRuleContext {
		public Expression syn_expression_mem;
		public ExpressionMethodsContext exp_method;
		public ExpressionMemTempContext exp_mem_temp;
		public ExpressionMethodsContext expressionMethods() {
			return getRuleContext(ExpressionMethodsContext.class,0);
		}
		public ExpressionMemTempContext expressionMemTemp() {
			return getRuleContext(ExpressionMemTempContext.class,0);
		}
		public ExpressionMemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMemContext expressionMem() throws RecognitionException {
		ExpressionMemContext _localctx = new ExpressionMemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionMem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			((ExpressionMemContext)_localctx).exp_method = expressionMethods();
			setState(338);
			((ExpressionMemContext)_localctx).exp_mem_temp = expressionMemTemp();

			        if(((ExpressionMemContext)_localctx).exp_mem_temp.syn_expression_mem_temp == null)
			            ((ExpressionMemContext)_localctx).syn_expression_mem =  ((ExpressionMemContext)_localctx).exp_method.syn_expression_method;
			        else
			            ((ExpressionMemContext)_localctx).syn_expression_mem =  new ArrayCall(((ExpressionMemContext)_localctx).exp_method.syn_expression_method, ((ExpressionMemContext)_localctx).exp_mem_temp.syn_expression_mem_temp);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemTempContext extends ParserRuleContext {
		public Expression syn_expression_mem_temp;
		public Token bracket;
		public ExpressionContext exp;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMemTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMemTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMemTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMemTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMemTempContext expressionMemTemp() throws RecognitionException {
		ExpressionMemTempContext _localctx = new ExpressionMemTempContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionMemTemp);
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				((ExpressionMemTempContext)_localctx).bracket = match(T__30);
				setState(342);
				((ExpressionMemTempContext)_localctx).exp = expression();
				setState(343);
				match(T__31);
				((ExpressionMemTempContext)_localctx).syn_expression_mem_temp =  ((ExpressionMemTempContext)_localctx).exp.syn_expression;
				         _localctx.syn_expression_mem_temp.set_line_num(((ExpressionMemTempContext)_localctx).bracket.getLine());
				         
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsContext extends ParserRuleContext {
		public Expression syn_expression_method;
		public ExpressionOtherContext exp_other;
		public ExpressionMethodsTempContext exp_method_temp;
		public ExpressionOtherContext expressionOther() {
			return getRuleContext(ExpressionOtherContext.class,0);
		}
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public ExpressionMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethods(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMethodsContext expressionMethods() throws RecognitionException {
		ExpressionMethodsContext _localctx = new ExpressionMethodsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionMethods);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			((ExpressionMethodsContext)_localctx).exp_other = expressionOther();
			setState(350);
			((ExpressionMethodsContext)_localctx).exp_method_temp = expressionMethodsTemp(((ExpressionMethodsContext)_localctx).exp_other.syn_expression_other);

			          if(((ExpressionMethodsContext)_localctx).exp_method_temp.syn_expression_method_temp == null)
			            ((ExpressionMethodsContext)_localctx).syn_expression_method =  ((ExpressionMethodsContext)_localctx).exp_other.syn_expression_other;
			          else
			            ((ExpressionMethodsContext)_localctx).syn_expression_method =  ((ExpressionMethodsContext)_localctx).exp_method_temp.syn_expression_method_temp;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsTempContext extends ParserRuleContext {
		public Expression inh_expression_other;
		public Expression syn_expression_method_temp;
		public Token method_name1;
		public Token method_name2;
		public ExpressionContext exp_arg1;
		public ExpressionContext exp_arg2;
		public ExpressionMethodsTempContext exp_method_temp;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState, Expression inh_expression_other) {
			super(parent, invokingState);
			this.inh_expression_other = inh_expression_other;
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethodsTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethodsTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionMethodsTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp(Expression inh_expression_other) throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState(), inh_expression_other);
		enterRule(_localctx, 60, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				match(T__32);
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(354);
					((ExpressionMethodsTempContext)_localctx).method_name1 = match(ID);
					setState(355);
					match(T__3);
					setState(356);
					match(T__4);
					((ExpressionMethodsTempContext)_localctx).syn_expression_method_temp =  new MethodCall(_localctx.inh_expression_other, new Identifier((((ExpressionMethodsTempContext)_localctx).method_name1!=null?((ExpressionMethodsTempContext)_localctx).method_name1.getText():null), ((ExpressionMethodsTempContext)_localctx).method_name1.getLine())); _localctx.syn_expression_method_temp.set_line_num(((ExpressionMethodsTempContext)_localctx).method_name1.getLine());
					}
					break;
				case 2:
					{
					setState(358);
					((ExpressionMethodsTempContext)_localctx).method_name2 = match(ID);
					MethodCall method_call = new MethodCall(_localctx.inh_expression_other, new Identifier((((ExpressionMethodsTempContext)_localctx).method_name2!=null?((ExpressionMethodsTempContext)_localctx).method_name2.getText():null), ((ExpressionMethodsTempContext)_localctx).method_name2.getLine())); method_call.set_line_num(((ExpressionMethodsTempContext)_localctx).method_name2.getLine());
					setState(360);
					match(T__3);
					{
					setState(361);
					((ExpressionMethodsTempContext)_localctx).exp_arg1 = expression();
					method_call.addArg(((ExpressionMethodsTempContext)_localctx).exp_arg1.syn_expression); 
					setState(369);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(363);
						match(T__12);
						setState(364);
						((ExpressionMethodsTempContext)_localctx).exp_arg2 = expression();
						method_call.addArg(((ExpressionMethodsTempContext)_localctx).exp_arg2.syn_expression); 
						}
						}
						setState(371);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(372);
					match(T__4);
					 ((ExpressionMethodsTempContext)_localctx).syn_expression_method_temp =  method_call; 
					}
					break;
				case 3:
					{
					setState(375);
					match(T__33);
					((ExpressionMethodsTempContext)_localctx).syn_expression_method_temp =  new Length(_localctx.inh_expression_other); 
					}
					break;
				}
				setState(379);
				((ExpressionMethodsTempContext)_localctx).exp_method_temp = expressionMethodsTemp(_localctx.syn_expression_method_temp);
				 ((ExpressionMethodsTempContext)_localctx).syn_expression_method_temp =  ((ExpressionMethodsTempContext)_localctx).exp_method_temp.syn_expression_method_temp; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionMethodsTempContext)_localctx).syn_expression_method_temp =  _localctx.inh_expression_other;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOtherContext extends ParserRuleContext {
		public Expression syn_expression_other;
		public Token const_num;
		public Token const_str;
		public Token class_name;
		public Token pointer_str;
		public Token bool_str;
		public Token identifier;
		public Token array_name;
		public ExpressionContext array_index;
		public Token lpar;
		public ExpressionContext expr;
		public TerminalNode CONST_NUM() { return getToken(SmoolaParser.CONST_NUM, 0); }
		public TerminalNode CONST_STR() { return getToken(SmoolaParser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOther; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOther(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOther(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitExpressionOther(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionOtherContext expressionOther() throws RecognitionException {
		ExpressionOtherContext _localctx = new ExpressionOtherContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressionOther);
		try {
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				((ExpressionOtherContext)_localctx).const_num = match(CONST_NUM);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new IntValue((((ExpressionOtherContext)_localctx).const_num!=null?Integer.valueOf(((ExpressionOtherContext)_localctx).const_num.getText()):0), new IntType()); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).const_num.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				((ExpressionOtherContext)_localctx).const_str = match(CONST_STR);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new StringValue((((ExpressionOtherContext)_localctx).const_str!=null?((ExpressionOtherContext)_localctx).const_str.getText():null), new StringType()); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).const_str.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				((ExpressionOtherContext)_localctx).const_str = match(T__34);
				setState(390);
				match(T__6);
				setState(391);
				match(T__30);
				setState(392);
				((ExpressionOtherContext)_localctx).const_num = match(CONST_NUM);
				setState(393);
				match(T__31);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new NewArray((((ExpressionOtherContext)_localctx).const_num!=null?Integer.valueOf(((ExpressionOtherContext)_localctx).const_num.getText()):0)); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).const_str.getLine());
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(395);
				match(T__34);
				setState(396);
				((ExpressionOtherContext)_localctx).class_name = match(ID);
				setState(397);
				match(T__3);
				setState(398);
				match(T__4);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new NewClass(new Identifier((((ExpressionOtherContext)_localctx).class_name!=null?((ExpressionOtherContext)_localctx).class_name.getText():null), ((ExpressionOtherContext)_localctx).class_name.getLine())); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).class_name.getLine());
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(400);
				((ExpressionOtherContext)_localctx).pointer_str = match(T__35);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new This(); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).pointer_str.getLine());
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(402);
				((ExpressionOtherContext)_localctx).bool_str = match(T__36);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new BooleanValue(true, new BooleanType()); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).bool_str.getLine()); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(404);
				((ExpressionOtherContext)_localctx).bool_str = match(T__37);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new BooleanValue(false, new BooleanType()); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).bool_str.getLine()); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(406);
				((ExpressionOtherContext)_localctx).identifier = match(ID);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new Identifier((((ExpressionOtherContext)_localctx).identifier!=null?((ExpressionOtherContext)_localctx).identifier.getText():null), ((ExpressionOtherContext)_localctx).identifier.getLine()); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).identifier.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(408);
				((ExpressionOtherContext)_localctx).array_name = match(ID);
				setState(409);
				match(T__30);
				setState(410);
				((ExpressionOtherContext)_localctx).array_index = expression();
				setState(411);
				match(T__31);
				((ExpressionOtherContext)_localctx).syn_expression_other =  new ArrayCall(new Identifier((((ExpressionOtherContext)_localctx).array_name!=null?((ExpressionOtherContext)_localctx).array_name.getText():null), ((ExpressionOtherContext)_localctx).array_name.getLine()), ((ExpressionOtherContext)_localctx).array_index.syn_expression); _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).array_name.getLine());
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(414);
				((ExpressionOtherContext)_localctx).lpar = match(T__3);
				setState(415);
				((ExpressionOtherContext)_localctx).expr = expression();
				setState(416);
				match(T__4);
				((ExpressionOtherContext)_localctx).syn_expression_other =  ((ExpressionOtherContext)_localctx).expr.syn_expression; _localctx.syn_expression_other.set_line_num(((ExpressionOtherContext)_localctx).lpar.getLine()); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type syn_type;
		public Token class_name;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmoolaVisitor ) return ((SmoolaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				match(T__6);
				((TypeContext)_localctx).syn_type =  new IntType(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(T__38);
				((TypeContext)_localctx).syn_type =  new BooleanType(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				match(T__39);
				((TypeContext)_localctx).syn_type =  new StringType(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				match(T__6);
				setState(428);
				match(T__30);
				setState(429);
				match(T__31);
				((TypeContext)_localctx).syn_type =  new ArrayType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(431);
				((TypeContext)_localctx).class_name = match(ID);

				            ((TypeContext)_localctx).syn_type =  new UserDefinedType(new Identifier((((TypeContext)_localctx).class_name!=null?((TypeContext)_localctx).class_name.getText():null), ((TypeContext)_localctx).class_name.getLine()));
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u01b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\4\3\4\3\4"+
		"\3\4\7\4v\n\4\f\4\16\4y\13\4\3\4\3\4\3\4\7\4~\n\4\f\4\16\4\u0081\13\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u009d\n\6\f\6\16\6\u00a0\13\6\3"+
		"\6\3\6\5\6\u00a4\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ad\n\6\f\6\16"+
		"\6\u00b0\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u00be"+
		"\n\7\f\7\16\7\u00c1\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00d2\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u00e1\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u0101\n\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u010d\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0119\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0125\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0131\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u013d\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u0149\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0152\n\34\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u015e\n\36\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0172\n \f \16"+
		" \u0175\13 \3 \3 \3 \3 \3 \5 \u017c\n \3 \3 \3 \3 \5 \u0182\n \3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01a6\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\5\"\u01b4\n\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\7\3\2\30\31\3\2\32\33\3\2\34\35"+
		"\3\2\36\37\4\2\35\35  \2\u01bb\2D\3\2\2\2\4R\3\2\2\2\6i\3\2\2\2\b\u0085"+
		"\3\2\2\2\n\u008c\3\2\2\2\f\u00b9\3\2\2\2\16\u00d1\3\2\2\2\20\u00d3\3\2"+
		"\2\2\22\u00d8\3\2\2\2\24\u00e4\3\2\2\2\26\u00eb\3\2\2\2\30\u00f1\3\2\2"+
		"\2\32\u00f5\3\2\2\2\34\u0100\3\2\2\2\36\u0102\3\2\2\2 \u010c\3\2\2\2\""+
		"\u010e\3\2\2\2$\u0118\3\2\2\2&\u011a\3\2\2\2(\u0124\3\2\2\2*\u0126\3\2"+
		"\2\2,\u0130\3\2\2\2.\u0132\3\2\2\2\60\u013c\3\2\2\2\62\u013e\3\2\2\2\64"+
		"\u0148\3\2\2\2\66\u0151\3\2\2\28\u0153\3\2\2\2:\u015d\3\2\2\2<\u015f\3"+
		"\2\2\2>\u0181\3\2\2\2@\u01a5\3\2\2\2B\u01b3\3\2\2\2DE\5\4\3\2EK\b\2\1"+
		"\2FG\5\6\4\2GH\b\2\1\2HJ\3\2\2\2IF\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2LN\3\2\2\2MK\3\2\2\2NO\b\2\1\2OP\7\2\2\3PQ\b\2\1\2Q\3\3\2\2\2RS\7\3"+
		"\2\2ST\7.\2\2TU\b\3\1\2UV\7\4\2\2VW\7\5\2\2WX\7.\2\2XY\7\6\2\2YZ\7\7\2"+
		"\2Z[\7\b\2\2[\\\7\t\2\2\\]\b\3\1\2]^\b\3\1\2^_\7\4\2\2_`\5\f\7\2`a\b\3"+
		"\1\2ab\7\n\2\2bc\5\32\16\2cd\b\3\1\2de\7\13\2\2ef\7\f\2\2fg\7\f\2\2gh"+
		"\b\3\1\2h\5\3\2\2\2ij\7\3\2\2jk\7.\2\2ko\b\4\1\2lm\7\r\2\2mn\7.\2\2np"+
		"\b\4\1\2ol\3\2\2\2op\3\2\2\2pq\3\2\2\2qw\7\4\2\2rs\5\b\5\2st\b\4\1\2t"+
		"v\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\177\3\2\2\2yw\3\2\2"+
		"\2z{\5\n\6\2{|\b\4\1\2|~\3\2\2\2}z\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7"+
		"\f\2\2\u0083\u0084\b\4\1\2\u0084\7\3\2\2\2\u0085\u0086\7\16\2\2\u0086"+
		"\u0087\7.\2\2\u0087\u0088\7\b\2\2\u0088\u0089\5B\"\2\u0089\u008a\7\13"+
		"\2\2\u008a\u008b\b\5\1\2\u008b\t\3\2\2\2\u008c\u008d\7\5\2\2\u008d\u008e"+
		"\7.\2\2\u008e\u00a3\b\6\1\2\u008f\u0090\7\6\2\2\u0090\u00a4\7\7\2\2\u0091"+
		"\u0092\7\6\2\2\u0092\u0093\7.\2\2\u0093\u0094\7\b\2\2\u0094\u0095\5B\""+
		"\2\u0095\u009e\b\6\1\2\u0096\u0097\7\17\2\2\u0097\u0098\7.\2\2\u0098\u0099"+
		"\7\b\2\2\u0099\u009a\5B\"\2\u009a\u009b\b\6\1\2\u009b\u009d\3\2\2\2\u009c"+
		"\u0096\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\7\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u008f\3\2\2\2\u00a3\u0091\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\7\b\2\2\u00a6\u00a7\5B\"\2\u00a7\u00a8\b\6\1\2\u00a8"+
		"\u00ae\7\4\2\2\u00a9\u00aa\5\b\5\2\u00aa\u00ab\b\6\1\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\5\f"+
		"\7\2\u00b2\u00b3\b\6\1\2\u00b3\u00b4\7\n\2\2\u00b4\u00b5\5\32\16\2\u00b5"+
		"\u00b6\b\6\1\2\u00b6\u00b7\7\13\2\2\u00b7\u00b8\7\f\2\2\u00b8\13\3\2\2"+
		"\2\u00b9\u00bf\b\7\1\2\u00ba\u00bb\5\16\b\2\u00bb\u00bc\b\7\1\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\r\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3"+
		"\5\20\t\2\u00c3\u00c4\b\b\1\2\u00c4\u00d2\3\2\2\2\u00c5\u00c6\5\22\n\2"+
		"\u00c6\u00c7\b\b\1\2\u00c7\u00d2\3\2\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00ca"+
		"\b\b\1\2\u00ca\u00d2\3\2\2\2\u00cb\u00cc\5\26\f\2\u00cc\u00cd\b\b\1\2"+
		"\u00cd\u00d2\3\2\2\2\u00ce\u00cf\5\30\r\2\u00cf\u00d0\b\b\1\2\u00d0\u00d2"+
		"\3\2\2\2\u00d1\u00c2\3\2\2\2\u00d1\u00c5\3\2\2\2\u00d1\u00c8\3\2\2\2\u00d1"+
		"\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\17\3\2\2\2\u00d3\u00d4\7\4\2"+
		"\2\u00d4\u00d5\5\f\7\2\u00d5\u00d6\7\f\2\2\u00d6\u00d7\b\t\1\2\u00d7\21"+
		"\3\2\2\2\u00d8\u00d9\7\20\2\2\u00d9\u00da\7\6\2\2\u00da\u00db\5\32\16"+
		"\2\u00db\u00dc\7\7\2\2\u00dc\u00dd\7\21\2\2\u00dd\u00e0\5\16\b\2\u00de"+
		"\u00df\7\22\2\2\u00df\u00e1\5\16\b\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\n\1\2\u00e3\23\3\2\2\2\u00e4"+
		"\u00e5\7\23\2\2\u00e5\u00e6\7\6\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8"+
		"\7\7\2\2\u00e8\u00e9\5\16\b\2\u00e9\u00ea\b\13\1\2\u00ea\25\3\2\2\2\u00eb"+
		"\u00ec\7\24\2\2\u00ec\u00ed\5\32\16\2\u00ed\u00ee\b\f\1\2\u00ee\u00ef"+
		"\7\7\2\2\u00ef\u00f0\7\13\2\2\u00f0\27\3\2\2\2\u00f1\u00f2\5\32\16\2\u00f2"+
		"\u00f3\b\r\1\2\u00f3\u00f4\7\13\2\2\u00f4\31\3\2\2\2\u00f5\u00f6\5\34"+
		"\17\2\u00f6\u00f7\b\16\1\2\u00f7\33\3\2\2\2\u00f8\u00f9\5\36\20\2\u00f9"+
		"\u00fa\7\25\2\2\u00fa\u00fb\5\34\17\2\u00fb\u00fc\b\17\1\2\u00fc\u0101"+
		"\3\2\2\2\u00fd\u00fe\5\36\20\2\u00fe\u00ff\b\17\1\2\u00ff\u0101\3\2\2"+
		"\2\u0100\u00f8\3\2\2\2\u0100\u00fd\3\2\2\2\u0101\35\3\2\2\2\u0102\u0103"+
		"\5\"\22\2\u0103\u0104\5 \21\2\u0104\u0105\b\20\1\2\u0105\37\3\2\2\2\u0106"+
		"\u0107\7\26\2\2\u0107\u0108\5\"\22\2\u0108\u0109\5 \21\2\u0109\u010a\b"+
		"\21\1\2\u010a\u010d\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u0106\3\2\2\2\u010c"+
		"\u010b\3\2\2\2\u010d!\3\2\2\2\u010e\u010f\5&\24\2\u010f\u0110\5$\23\2"+
		"\u0110\u0111\b\22\1\2\u0111#\3\2\2\2\u0112\u0113\7\27\2\2\u0113\u0114"+
		"\5&\24\2\u0114\u0115\5$\23\2\u0115\u0116\b\23\1\2\u0116\u0119\3\2\2\2"+
		"\u0117\u0119\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0117\3\2\2\2\u0119%\3"+
		"\2\2\2\u011a\u011b\5*\26\2\u011b\u011c\5(\25\2\u011c\u011d\b\24\1\2\u011d"+
		"\'\3\2\2\2\u011e\u011f\t\2\2\2\u011f\u0120\5*\26\2\u0120\u0121\5(\25\2"+
		"\u0121\u0122\b\25\1\2\u0122\u0125\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u011e"+
		"\3\2\2\2\u0124\u0123\3\2\2\2\u0125)\3\2\2\2\u0126\u0127\5.\30\2\u0127"+
		"\u0128\5,\27\2\u0128\u0129\b\26\1\2\u0129+\3\2\2\2\u012a\u012b\t\3\2\2"+
		"\u012b\u012c\5.\30\2\u012c\u012d\5,\27\2\u012d\u012e\b\27\1\2\u012e\u0131"+
		"\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012a\3\2\2\2\u0130\u012f\3\2\2\2\u0131"+
		"-\3\2\2\2\u0132\u0133\5\62\32\2\u0133\u0134\5\60\31\2\u0134\u0135\b\30"+
		"\1\2\u0135/\3\2\2\2\u0136\u0137\t\4\2\2\u0137\u0138\5\62\32\2\u0138\u0139"+
		"\5\60\31\2\u0139\u013a\b\31\1\2\u013a\u013d\3\2\2\2\u013b\u013d\3\2\2"+
		"\2\u013c\u0136\3\2\2\2\u013c\u013b\3\2\2\2\u013d\61\3\2\2\2\u013e\u013f"+
		"\5\66\34\2\u013f\u0140\5\64\33\2\u0140\u0141\b\32\1\2\u0141\63\3\2\2\2"+
		"\u0142\u0143\t\5\2\2\u0143\u0144\5\66\34\2\u0144\u0145\5\64\33\2\u0145"+
		"\u0146\b\33\1\2\u0146\u0149\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0142\3"+
		"\2\2\2\u0148\u0147\3\2\2\2\u0149\65\3\2\2\2\u014a\u014b\t\6\2\2\u014b"+
		"\u014c\5\66\34\2\u014c\u014d\b\34\1\2\u014d\u0152\3\2\2\2\u014e\u014f"+
		"\58\35\2\u014f\u0150\b\34\1\2\u0150\u0152\3\2\2\2\u0151\u014a\3\2\2\2"+
		"\u0151\u014e\3\2\2\2\u0152\67\3\2\2\2\u0153\u0154\5<\37\2\u0154\u0155"+
		"\5:\36\2\u0155\u0156\b\35\1\2\u01569\3\2\2\2\u0157\u0158\7!\2\2\u0158"+
		"\u0159\5\32\16\2\u0159\u015a\7\"\2\2\u015a\u015b\b\36\1\2\u015b\u015e"+
		"\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u0157\3\2\2\2\u015d\u015c\3\2\2\2\u015e"+
		";\3\2\2\2\u015f\u0160\5@!\2\u0160\u0161\5> \2\u0161\u0162\b\37\1\2\u0162"+
		"=\3\2\2\2\u0163\u017b\7#\2\2\u0164\u0165\7.\2\2\u0165\u0166\7\6\2\2\u0166"+
		"\u0167\7\7\2\2\u0167\u017c\b \1\2\u0168\u0169\7.\2\2\u0169\u016a\b \1"+
		"\2\u016a\u016b\7\6\2\2\u016b\u016c\5\32\16\2\u016c\u0173\b \1\2\u016d"+
		"\u016e\7\17\2\2\u016e\u016f\5\32\16\2\u016f\u0170\b \1\2\u0170\u0172\3"+
		"\2\2\2\u0171\u016d\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7\7"+
		"\2\2\u0177\u0178\b \1\2\u0178\u017c\3\2\2\2\u0179\u017a\7$\2\2\u017a\u017c"+
		"\b \1\2\u017b\u0164\3\2\2\2\u017b\u0168\3\2\2\2\u017b\u0179\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017e\5> \2\u017e\u017f\b \1\2\u017f\u0182\3\2\2"+
		"\2\u0180\u0182\b \1\2\u0181\u0163\3\2\2\2\u0181\u0180\3\2\2\2\u0182?\3"+
		"\2\2\2\u0183\u0184\7+\2\2\u0184\u01a6\b!\1\2\u0185\u0186\7,\2\2\u0186"+
		"\u01a6\b!\1\2\u0187\u0188\7%\2\2\u0188\u0189\7\t\2\2\u0189\u018a\7!\2"+
		"\2\u018a\u018b\7+\2\2\u018b\u018c\7\"\2\2\u018c\u01a6\b!\1\2\u018d\u018e"+
		"\7%\2\2\u018e\u018f\7.\2\2\u018f\u0190\7\6\2\2\u0190\u0191\7\7\2\2\u0191"+
		"\u01a6\b!\1\2\u0192\u0193\7&\2\2\u0193\u01a6\b!\1\2\u0194\u0195\7\'\2"+
		"\2\u0195\u01a6\b!\1\2\u0196\u0197\7(\2\2\u0197\u01a6\b!\1\2\u0198\u0199"+
		"\7.\2\2\u0199\u01a6\b!\1\2\u019a\u019b\7.\2\2\u019b\u019c\7!\2\2\u019c"+
		"\u019d\5\32\16\2\u019d\u019e\7\"\2\2\u019e\u019f\b!\1\2\u019f\u01a6\3"+
		"\2\2\2\u01a0\u01a1\7\6\2\2\u01a1\u01a2\5\32\16\2\u01a2\u01a3\7\7\2\2\u01a3"+
		"\u01a4\b!\1\2\u01a4\u01a6\3\2\2\2\u01a5\u0183\3\2\2\2\u01a5\u0185\3\2"+
		"\2\2\u01a5\u0187\3\2\2\2\u01a5\u018d\3\2\2\2\u01a5\u0192\3\2\2\2\u01a5"+
		"\u0194\3\2\2\2\u01a5\u0196\3\2\2\2\u01a5\u0198\3\2\2\2\u01a5\u019a\3\2"+
		"\2\2\u01a5\u01a0\3\2\2\2\u01a6A\3\2\2\2\u01a7\u01a8\7\t\2\2\u01a8\u01b4"+
		"\b\"\1\2\u01a9\u01aa\7)\2\2\u01aa\u01b4\b\"\1\2\u01ab\u01ac\7*\2\2\u01ac"+
		"\u01b4\b\"\1\2\u01ad\u01ae\7\t\2\2\u01ae\u01af\7!\2\2\u01af\u01b0\7\""+
		"\2\2\u01b0\u01b4\b\"\1\2\u01b1\u01b2\7.\2\2\u01b2\u01b4\b\"\1\2\u01b3"+
		"\u01a7\3\2\2\2\u01b3\u01a9\3\2\2\2\u01b3\u01ab\3\2\2\2\u01b3\u01ad\3\2"+
		"\2\2\u01b3\u01b1\3\2\2\2\u01b4C\3\2\2\2\32Kow\177\u009e\u00a3\u00ae\u00bf"+
		"\u00d1\u00e0\u0100\u010c\u0118\u0124\u0130\u013c\u0148\u0151\u015d\u0173"+
		"\u017b\u0181\u01a5\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}