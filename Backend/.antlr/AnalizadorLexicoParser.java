// Generated from /home/javier/Documentos/Compi2/Proyecto1/Backend/AnalizadorLexico.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnalizadorLexicoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		NEWLINE=18, INT=19, DECIMAL=20, CARACTER=21, CADENA=22, BOOL=23, ID=24, 
		COMENTARIO_LINEA=25, COMENTARIO_BLOQUE=26, IGUAL=27, DOSPUNTOS_IGUAL=28, 
		PARENTESIS_ABRE=29, PARENTESIS_CIERRA=30, CORCHETE_ABRE=31, CORCHETE_CIERRA=32, 
		LLAVE_ABRE=33, LLAVE_CIERRA=34, ASIGNACION_SUMA=35, ASIGNACION_RESTA=36, 
		MAS=37, MENOS=38, MULT=39, DIV=40, MODULO=41, Y_LOGICO=42, O_LOGICO=43, 
		NEGACION=44, IGUAL_IGUAL=45, DIFERENTE=46, MAYOR_IGUAL=47, MAYOR=48, MENOR_IGUAL=49, 
		MENOR=50, INCREMENTO=51, DECREMENTO=52;
	public static final int
		RULE_inicio = 0, RULE_listainstrucciones = 1, RULE_instruccion = 2, RULE_print = 3, 
		RULE_variables = 4, RULE_asignacion = 5, RULE_incrementoDecremento = 6, 
		RULE_instruccion_for = 7, RULE_instruccion_forcondicional = 8, RULE_instruccion_break = 9, 
		RULE_instruccion_continue = 10, RULE_tipo = 11, RULE_instruccion_if = 12, 
		RULE_instruccion_switch = 13, RULE_caso = 14, RULE_caso_default = 15, 
		RULE_expr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "listainstrucciones", "instruccion", "print", "variables", 
			"asignacion", "incrementoDecremento", "instruccion_for", "instruccion_forcondicional", 
			"instruccion_break", "instruccion_continue", "tipo", "instruccion_if", 
			"instruccion_switch", "caso", "caso_default", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fmt.Println'", "'var'", "'for'", "';'", "'break'", "'continue'", 
			"'int'", "'float64'", "'string'", "'bool'", "'rune'", "'if'", "'else'", 
			"'switch'", "'case'", "':'", "'default'", null, null, null, null, null, 
			null, null, null, null, "'='", "':='", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'+='", "'-='", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", 
			"'!'", "'=='", "'!='", "'>='", "'>'", "'<='", "'<'", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "NEWLINE", "INT", "DECIMAL", "CARACTER", 
			"CADENA", "BOOL", "ID", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "IGUAL", 
			"DOSPUNTOS_IGUAL", "PARENTESIS_ABRE", "PARENTESIS_CIERRA", "CORCHETE_ABRE", 
			"CORCHETE_CIERRA", "LLAVE_ABRE", "LLAVE_CIERRA", "ASIGNACION_SUMA", "ASIGNACION_RESTA", 
			"MAS", "MENOS", "MULT", "DIV", "MODULO", "Y_LOGICO", "O_LOGICO", "NEGACION", 
			"IGUAL_IGUAL", "DIFERENTE", "MAYOR_IGUAL", "MAYOR", "MENOR_IGUAL", "MENOR", 
			"INCREMENTO", "DECREMENTO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "AnalizadorLexico.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnalizadorLexicoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public ListainstruccionesContext listainstrucciones() {
			return getRuleContext(ListainstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AnalizadorLexicoParser.EOF, 0); }
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			listainstrucciones();
			setState(35);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListainstruccionesContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ListainstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listainstrucciones; }
	}

	public final ListainstruccionesContext listainstrucciones() throws RecognitionException {
		ListainstruccionesContext _localctx = new ListainstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listainstrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16797806L) != 0)) {
				{
				{
				setState(37);
				instruccion();
				}
				}
				setState(42);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public Instruccion_ifContext instruccion_if() {
			return getRuleContext(Instruccion_ifContext.class,0);
		}
		public Instruccion_switchContext instruccion_switch() {
			return getRuleContext(Instruccion_switchContext.class,0);
		}
		public IncrementoDecrementoContext incrementoDecremento() {
			return getRuleContext(IncrementoDecrementoContext.class,0);
		}
		public Instruccion_forContext instruccion_for() {
			return getRuleContext(Instruccion_forContext.class,0);
		}
		public Instruccion_forcondicionalContext instruccion_forcondicional() {
			return getRuleContext(Instruccion_forcondicionalContext.class,0);
		}
		public Instruccion_breakContext instruccion_break() {
			return getRuleContext(Instruccion_breakContext.class,0);
		}
		public Instruccion_continueContext instruccion_continue() {
			return getRuleContext(Instruccion_continueContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				print();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				variables();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				instruccion_if();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				instruccion_switch();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				incrementoDecremento();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				instruccion_for();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				instruccion_forcondicional();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				instruccion_break();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(52);
				instruccion_continue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorLexicoParser.PARENTESIS_ABRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorLexicoParser.PARENTESIS_CIERRA, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__0);
			setState(56);
			match(PARENTESIS_ABRE);
			setState(57);
			expr(0);
			setState(58);
			match(PARENTESIS_CIERRA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesContext extends ParserRuleContext {
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
	 
		public VariablesContext() { }
		public void copyFrom(VariablesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionVarContext extends VariablesContext {
		public Token identificador;
		public TipoContext tipoVar;
		public ExprContext valor;
		public TerminalNode ID() { return getToken(AnalizadorLexicoParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(AnalizadorLexicoParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracionVarContext(VariablesContext ctx) { copyFrom(ctx); }
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variables);
		int _la;
		try {
			_localctx = new DeclaracionVarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__1);
			setState(61);
			((DeclaracionVarContext)_localctx).identificador = match(ID);
			setState(62);
			((DeclaracionVarContext)_localctx).tipoVar = tipo();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(63);
				match(IGUAL);
				setState(64);
				((DeclaracionVarContext)_localctx).valor = expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionVarContext extends AsignacionContext {
		public Token signo;
		public TerminalNode ID() { return getToken(AnalizadorLexicoParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(AnalizadorLexicoParser.IGUAL, 0); }
		public TerminalNode DOSPUNTOS_IGUAL() { return getToken(AnalizadorLexicoParser.DOSPUNTOS_IGUAL, 0); }
		public TerminalNode ASIGNACION_SUMA() { return getToken(AnalizadorLexicoParser.ASIGNACION_SUMA, 0); }
		public TerminalNode ASIGNACION_RESTA() { return getToken(AnalizadorLexicoParser.ASIGNACION_RESTA, 0); }
		public AsignacionVarContext(AsignacionContext ctx) { copyFrom(ctx); }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asignacion);
		int _la;
		try {
			_localctx = new AsignacionVarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(ID);
			setState(68);
			((AsignacionVarContext)_localctx).signo = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 103481868288L) != 0)) ) {
				((AsignacionVarContext)_localctx).signo = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(69);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoDecrementoContext extends ParserRuleContext {
		public IncrementoDecrementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementoDecremento; }
	 
		public IncrementoDecrementoContext() { }
		public void copyFrom(IncrementoDecrementoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoDecrementoInstruccionContext extends IncrementoDecrementoContext {
		public TerminalNode ID() { return getToken(AnalizadorLexicoParser.ID, 0); }
		public TerminalNode INCREMENTO() { return getToken(AnalizadorLexicoParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(AnalizadorLexicoParser.DECREMENTO, 0); }
		public IncrementoDecrementoInstruccionContext(IncrementoDecrementoContext ctx) { copyFrom(ctx); }
	}

	public final IncrementoDecrementoContext incrementoDecremento() throws RecognitionException {
		IncrementoDecrementoContext _localctx = new IncrementoDecrementoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_incrementoDecremento);
		int _la;
		try {
			_localctx = new IncrementoDecrementoInstruccionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ID);
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_forContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LLAVE_ABRE() { return getToken(AnalizadorLexicoParser.LLAVE_ABRE, 0); }
		public ListainstruccionesContext listainstrucciones() {
			return getRuleContext(ListainstruccionesContext.class,0);
		}
		public TerminalNode LLAVE_CIERRA() { return getToken(AnalizadorLexicoParser.LLAVE_CIERRA, 0); }
		public Instruccion_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_for; }
	}

	public final Instruccion_forContext instruccion_for() throws RecognitionException {
		Instruccion_forContext _localctx = new Instruccion_forContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instruccion_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__2);
			setState(75);
			expr(0);
			setState(76);
			match(LLAVE_ABRE);
			setState(77);
			listainstrucciones();
			setState(78);
			match(LLAVE_CIERRA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_forcondicionalContext extends ParserRuleContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IncrementoDecrementoContext incrementoDecremento() {
			return getRuleContext(IncrementoDecrementoContext.class,0);
		}
		public TerminalNode LLAVE_ABRE() { return getToken(AnalizadorLexicoParser.LLAVE_ABRE, 0); }
		public ListainstruccionesContext listainstrucciones() {
			return getRuleContext(ListainstruccionesContext.class,0);
		}
		public TerminalNode LLAVE_CIERRA() { return getToken(AnalizadorLexicoParser.LLAVE_CIERRA, 0); }
		public Instruccion_forcondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_forcondicional; }
	}

	public final Instruccion_forcondicionalContext instruccion_forcondicional() throws RecognitionException {
		Instruccion_forcondicionalContext _localctx = new Instruccion_forcondicionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruccion_forcondicional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__2);
			setState(81);
			asignacion();
			setState(82);
			match(T__3);
			setState(83);
			expr(0);
			setState(84);
			match(T__3);
			setState(85);
			incrementoDecremento();
			setState(86);
			match(LLAVE_ABRE);
			setState(87);
			listainstrucciones();
			setState(88);
			match(LLAVE_CIERRA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_breakContext extends ParserRuleContext {
		public Instruccion_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_break; }
	}

	public final Instruccion_breakContext instruccion_break() throws RecognitionException {
		Instruccion_breakContext _localctx = new Instruccion_breakContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instruccion_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_continueContext extends ParserRuleContext {
		public Instruccion_continueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_continue; }
	}

	public final Instruccion_continueContext instruccion_continue() throws RecognitionException {
		Instruccion_continueContext _localctx = new Instruccion_continueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instruccion_continue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3968L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_ifContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> LLAVE_ABRE() { return getTokens(AnalizadorLexicoParser.LLAVE_ABRE); }
		public TerminalNode LLAVE_ABRE(int i) {
			return getToken(AnalizadorLexicoParser.LLAVE_ABRE, i);
		}
		public List<ListainstruccionesContext> listainstrucciones() {
			return getRuleContexts(ListainstruccionesContext.class);
		}
		public ListainstruccionesContext listainstrucciones(int i) {
			return getRuleContext(ListainstruccionesContext.class,i);
		}
		public List<TerminalNode> LLAVE_CIERRA() { return getTokens(AnalizadorLexicoParser.LLAVE_CIERRA); }
		public TerminalNode LLAVE_CIERRA(int i) {
			return getToken(AnalizadorLexicoParser.LLAVE_CIERRA, i);
		}
		public Instruccion_ifContext instruccion_if() {
			return getRuleContext(Instruccion_ifContext.class,0);
		}
		public Instruccion_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_if; }
	}

	public final Instruccion_ifContext instruccion_if() throws RecognitionException {
		Instruccion_ifContext _localctx = new Instruccion_ifContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_instruccion_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__11);
			setState(97);
			expr(0);
			setState(98);
			match(LLAVE_ABRE);
			setState(99);
			listainstrucciones();
			setState(100);
			match(LLAVE_CIERRA);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(101);
				match(T__12);
				setState(107);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(102);
					instruccion_if();
					}
					break;
				case LLAVE_ABRE:
					{
					setState(103);
					match(LLAVE_ABRE);
					setState(104);
					listainstrucciones();
					setState(105);
					match(LLAVE_CIERRA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruccion_switchContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LLAVE_ABRE() { return getToken(AnalizadorLexicoParser.LLAVE_ABRE, 0); }
		public TerminalNode LLAVE_CIERRA() { return getToken(AnalizadorLexicoParser.LLAVE_CIERRA, 0); }
		public List<CasoContext> caso() {
			return getRuleContexts(CasoContext.class);
		}
		public CasoContext caso(int i) {
			return getRuleContext(CasoContext.class,i);
		}
		public Caso_defaultContext caso_default() {
			return getRuleContext(Caso_defaultContext.class,0);
		}
		public Instruccion_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_switch; }
	}

	public final Instruccion_switchContext instruccion_switch() throws RecognitionException {
		Instruccion_switchContext _localctx = new Instruccion_switchContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instruccion_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__13);
			setState(112);
			expr(0);
			setState(113);
			match(LLAVE_ABRE);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(114);
				caso();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(120);
				caso_default();
				}
			}

			setState(123);
			match(LLAVE_CIERRA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CasoContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ListainstruccionesContext listainstrucciones() {
			return getRuleContext(ListainstruccionesContext.class,0);
		}
		public CasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caso; }
	}

	public final CasoContext caso() throws RecognitionException {
		CasoContext _localctx = new CasoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_caso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__14);
			setState(126);
			expr(0);
			setState(127);
			match(T__15);
			setState(128);
			listainstrucciones();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Caso_defaultContext extends ParserRuleContext {
		public ListainstruccionesContext listainstrucciones() {
			return getRuleContext(ListainstruccionesContext.class,0);
		}
		public Caso_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caso_default; }
	}

	public final Caso_defaultContext caso_default() throws RecognitionException {
		Caso_defaultContext _localctx = new Caso_defaultContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_caso_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__16);
			setState(131);
			match(T__15);
			setState(132);
			listainstrucciones();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperadorLogicoContext extends ExprContext {
		public ExprContext left;
		public Token operador;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Y_LOGICO() { return getToken(AnalizadorLexicoParser.Y_LOGICO, 0); }
		public TerminalNode O_LOGICO() { return getToken(AnalizadorLexicoParser.O_LOGICO, 0); }
		public OperadorLogicoContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpreParentesisContext extends ExprContext {
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorLexicoParser.PARENTESIS_ABRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorLexicoParser.PARENTESIS_CIERRA, 0); }
		public ExpreParentesisContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExpresionContext extends ExprContext {
		public TerminalNode ID() { return getToken(AnalizadorLexicoParser.ID, 0); }
		public IdExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperadorNegacionContext extends ExprContext {
		public Token operador;
		public ExprContext right;
		public TerminalNode NEGACION() { return getToken(AnalizadorLexicoParser.NEGACION, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OperadorNegacionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaracterExpresionContext extends ExprContext {
		public TerminalNode CARACTER() { return getToken(AnalizadorLexicoParser.CARACTER, 0); }
		public CaracterExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalExpresionContext extends ExprContext {
		public TerminalNode DECIMAL() { return getToken(AnalizadorLexicoParser.DECIMAL, 0); }
		public DecimalExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoleanExpresionContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(AnalizadorLexicoParser.BOOL, 0); }
		public BoleanExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CadenaExpresionContext extends ExprContext {
		public TerminalNode CADENA() { return getToken(AnalizadorLexicoParser.CADENA, 0); }
		public CadenaExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpreCorchetesContext extends ExprContext {
		public TerminalNode CORCHETE_ABRE() { return getToken(AnalizadorLexicoParser.CORCHETE_ABRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CORCHETE_CIERRA() { return getToken(AnalizadorLexicoParser.CORCHETE_CIERRA, 0); }
		public ExpreCorchetesContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicacionYdivisionContext extends ExprContext {
		public ExprContext left;
		public Token operador;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(AnalizadorLexicoParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(AnalizadorLexicoParser.DIV, 0); }
		public MultiplicacionYdivisionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExpresionContext extends ExprContext {
		public TerminalNode INT() { return getToken(AnalizadorLexicoParser.INT, 0); }
		public IntExpresionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperadorRelacionalContext extends ExprContext {
		public ExprContext left;
		public Token operador;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(AnalizadorLexicoParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(AnalizadorLexicoParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR() { return getToken(AnalizadorLexicoParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(AnalizadorLexicoParser.MAYOR_IGUAL, 0); }
		public TerminalNode IGUAL_IGUAL() { return getToken(AnalizadorLexicoParser.IGUAL_IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(AnalizadorLexicoParser.DIFERENTE, 0); }
		public OperadorRelacionalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperadorNegativoContext extends ExprContext {
		public Token operador;
		public ExprContext right;
		public TerminalNode MENOS() { return getToken(AnalizadorLexicoParser.MENOS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OperadorNegativoContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumaYrestaContext extends ExprContext {
		public ExprContext left;
		public Token operador;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAS() { return getToken(AnalizadorLexicoParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(AnalizadorLexicoParser.MENOS, 0); }
		public SumaYrestaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuloContext extends ExprContext {
		public ExprContext left;
		public Token operador;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MODULO() { return getToken(AnalizadorLexicoParser.MODULO, 0); }
		public ModuloContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENTESIS_ABRE:
				{
				_localctx = new ExpreParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(135);
				match(PARENTESIS_ABRE);
				setState(136);
				expr(0);
				setState(137);
				match(PARENTESIS_CIERRA);
				}
				break;
			case CORCHETE_ABRE:
				{
				_localctx = new ExpreCorchetesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(CORCHETE_ABRE);
				setState(140);
				expr(0);
				setState(141);
				match(CORCHETE_CIERRA);
				}
				break;
			case MENOS:
				{
				_localctx = new OperadorNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				((OperadorNegativoContext)_localctx).operador = match(MENOS);
				setState(144);
				((OperadorNegativoContext)_localctx).right = expr(19);
				}
				break;
			case NEGACION:
				{
				_localctx = new OperadorNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				((OperadorNegacionContext)_localctx).operador = match(NEGACION);
				setState(146);
				((OperadorNegacionContext)_localctx).right = expr(18);
				}
				break;
			case INT:
				{
				_localctx = new IntExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(INT);
				}
				break;
			case DECIMAL:
				{
				_localctx = new DecimalExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(DECIMAL);
				}
				break;
			case CARACTER:
				{
				_localctx = new CaracterExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(CARACTER);
				}
				break;
			case BOOL:
				{
				_localctx = new BoleanExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(BOOL);
				}
				break;
			case CADENA:
				{
				_localctx = new CadenaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(CADENA);
				}
				break;
			case ID:
				{
				_localctx = new IdExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionYdivisionContext(new ExprContext(_parentctx, _parentState));
						((MultiplicacionYdivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(156);
						((MultiplicacionYdivisionContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultiplicacionYdivisionContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						((MultiplicacionYdivisionContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ModuloContext(new ExprContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(159);
						((ModuloContext)_localctx).operador = match(MODULO);
						setState(160);
						((ModuloContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new SumaYrestaContext(new ExprContext(_parentctx, _parentState));
						((SumaYrestaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(162);
						((SumaYrestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
							((SumaYrestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(163);
						((SumaYrestaContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(165);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR);
						setState(166);
						((OperadorRelacionalContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(168);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR_IGUAL);
						setState(169);
						((OperadorRelacionalContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(171);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR);
						setState(172);
						((OperadorRelacionalContext)_localctx).right = expr(13);
						}
						break;
					case 7:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(174);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR_IGUAL);
						setState(175);
						((OperadorRelacionalContext)_localctx).right = expr(12);
						}
						break;
					case 8:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(177);
						((OperadorRelacionalContext)_localctx).operador = match(IGUAL_IGUAL);
						setState(178);
						((OperadorRelacionalContext)_localctx).right = expr(11);
						}
						break;
					case 9:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(180);
						((OperadorRelacionalContext)_localctx).operador = match(DIFERENTE);
						setState(181);
						((OperadorRelacionalContext)_localctx).right = expr(10);
						}
						break;
					case 10:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(183);
						((OperadorLogicoContext)_localctx).operador = match(Y_LOGICO);
						setState(184);
						((OperadorLogicoContext)_localctx).right = expr(9);
						}
						break;
					case 11:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(186);
						((OperadorLogicoContext)_localctx).operador = match(O_LOGICO);
						setState(187);
						((OperadorLogicoContext)_localctx).right = expr(8);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u00c2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\fl\b\f\u0003\fn\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\rt\b\r\n\r"+
		"\f\rw\t\r\u0001\r\u0003\rz\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u009a\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00bd\b\u0010\n\u0010\f\u0010\u00c0\t\u0010\u0001"+
		"\u0010\u0000\u0001 \u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0005\u0002\u0000\u001b\u001c"+
		"#$\u0001\u000034\u0001\u0000\u0007\u000b\u0001\u0000\'(\u0001\u0000%&"+
		"\u00d3\u0000\"\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b<\u0001"+
		"\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fG\u0001\u0000\u0000\u0000"+
		"\u000eJ\u0001\u0000\u0000\u0000\u0010P\u0001\u0000\u0000\u0000\u0012Z"+
		"\u0001\u0000\u0000\u0000\u0014\\\u0001\u0000\u0000\u0000\u0016^\u0001"+
		"\u0000\u0000\u0000\u0018`\u0001\u0000\u0000\u0000\u001ao\u0001\u0000\u0000"+
		"\u0000\u001c}\u0001\u0000\u0000\u0000\u001e\u0082\u0001\u0000\u0000\u0000"+
		" \u0099\u0001\u0000\u0000\u0000\"#\u0003\u0002\u0001\u0000#$\u0005\u0000"+
		"\u0000\u0001$\u0001\u0001\u0000\u0000\u0000%\'\u0003\u0004\u0002\u0000"+
		"&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000()\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*(\u0001"+
		"\u0000\u0000\u0000+6\u0003\u0006\u0003\u0000,6\u0003\b\u0004\u0000-6\u0003"+
		"\n\u0005\u0000.6\u0003\u0018\f\u0000/6\u0003\u001a\r\u000006\u0003\f\u0006"+
		"\u000016\u0003\u000e\u0007\u000026\u0003\u0010\b\u000036\u0003\u0012\t"+
		"\u000046\u0003\u0014\n\u00005+\u0001\u0000\u0000\u00005,\u0001\u0000\u0000"+
		"\u00005-\u0001\u0000\u0000\u00005.\u0001\u0000\u0000\u00005/\u0001\u0000"+
		"\u0000\u000050\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u000052\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u0000"+
		"6\u0005\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u000089\u0005\u001d"+
		"\u0000\u00009:\u0003 \u0010\u0000:;\u0005\u001e\u0000\u0000;\u0007\u0001"+
		"\u0000\u0000\u0000<=\u0005\u0002\u0000\u0000=>\u0005\u0018\u0000\u0000"+
		">A\u0003\u0016\u000b\u0000?@\u0005\u001b\u0000\u0000@B\u0003 \u0010\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\t\u0001\u0000\u0000"+
		"\u0000CD\u0005\u0018\u0000\u0000DE\u0007\u0000\u0000\u0000EF\u0003 \u0010"+
		"\u0000F\u000b\u0001\u0000\u0000\u0000GH\u0005\u0018\u0000\u0000HI\u0007"+
		"\u0001\u0000\u0000I\r\u0001\u0000\u0000\u0000JK\u0005\u0003\u0000\u0000"+
		"KL\u0003 \u0010\u0000LM\u0005!\u0000\u0000MN\u0003\u0002\u0001\u0000N"+
		"O\u0005\"\u0000\u0000O\u000f\u0001\u0000\u0000\u0000PQ\u0005\u0003\u0000"+
		"\u0000QR\u0003\n\u0005\u0000RS\u0005\u0004\u0000\u0000ST\u0003 \u0010"+
		"\u0000TU\u0005\u0004\u0000\u0000UV\u0003\f\u0006\u0000VW\u0005!\u0000"+
		"\u0000WX\u0003\u0002\u0001\u0000XY\u0005\"\u0000\u0000Y\u0011\u0001\u0000"+
		"\u0000\u0000Z[\u0005\u0005\u0000\u0000[\u0013\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0006\u0000\u0000]\u0015\u0001\u0000\u0000\u0000^_\u0007\u0002"+
		"\u0000\u0000_\u0017\u0001\u0000\u0000\u0000`a\u0005\f\u0000\u0000ab\u0003"+
		" \u0010\u0000bc\u0005!\u0000\u0000cd\u0003\u0002\u0001\u0000dm\u0005\""+
		"\u0000\u0000ek\u0005\r\u0000\u0000fl\u0003\u0018\f\u0000gh\u0005!\u0000"+
		"\u0000hi\u0003\u0002\u0001\u0000ij\u0005\"\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000kf\u0001\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000me\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0019"+
		"\u0001\u0000\u0000\u0000op\u0005\u000e\u0000\u0000pq\u0003 \u0010\u0000"+
		"qu\u0005!\u0000\u0000rt\u0003\u001c\u000e\u0000sr\u0001\u0000\u0000\u0000"+
		"tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0003\u001e"+
		"\u000f\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0005\"\u0000\u0000|\u001b\u0001\u0000\u0000\u0000"+
		"}~\u0005\u000f\u0000\u0000~\u007f\u0003 \u0010\u0000\u007f\u0080\u0005"+
		"\u0010\u0000\u0000\u0080\u0081\u0003\u0002\u0001\u0000\u0081\u001d\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005\u0011\u0000\u0000\u0083\u0084\u0005"+
		"\u0010\u0000\u0000\u0084\u0085\u0003\u0002\u0001\u0000\u0085\u001f\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0006\u0010\uffff\uffff\u0000\u0087\u0088"+
		"\u0005\u001d\u0000\u0000\u0088\u0089\u0003 \u0010\u0000\u0089\u008a\u0005"+
		"\u001e\u0000\u0000\u008a\u009a\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\u001f\u0000\u0000\u008c\u008d\u0003 \u0010\u0000\u008d\u008e\u0005 \u0000"+
		"\u0000\u008e\u009a\u0001\u0000\u0000\u0000\u008f\u0090\u0005&\u0000\u0000"+
		"\u0090\u009a\u0003 \u0010\u0013\u0091\u0092\u0005,\u0000\u0000\u0092\u009a"+
		"\u0003 \u0010\u0012\u0093\u009a\u0005\u0013\u0000\u0000\u0094\u009a\u0005"+
		"\u0014\u0000\u0000\u0095\u009a\u0005\u0015\u0000\u0000\u0096\u009a\u0005"+
		"\u0017\u0000\u0000\u0097\u009a\u0005\u0016\u0000\u0000\u0098\u009a\u0005"+
		"\u0018\u0000\u0000\u0099\u0086\u0001\u0000\u0000\u0000\u0099\u008b\u0001"+
		"\u0000\u0000\u0000\u0099\u008f\u0001\u0000\u0000\u0000\u0099\u0091\u0001"+
		"\u0000\u0000\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0094\u0001"+
		"\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u0099\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u00be\u0001\u0000\u0000\u0000\u009b\u009c\n\u0011"+
		"\u0000\u0000\u009c\u009d\u0007\u0003\u0000\u0000\u009d\u00bd\u0003 \u0010"+
		"\u0012\u009e\u009f\n\u0010\u0000\u0000\u009f\u00a0\u0005)\u0000\u0000"+
		"\u00a0\u00bd\u0003 \u0010\u0011\u00a1\u00a2\n\u000f\u0000\u0000\u00a2"+
		"\u00a3\u0007\u0004\u0000\u0000\u00a3\u00bd\u0003 \u0010\u0010\u00a4\u00a5"+
		"\n\u000e\u0000\u0000\u00a5\u00a6\u00052\u0000\u0000\u00a6\u00bd\u0003"+
		" \u0010\u000f\u00a7\u00a8\n\r\u0000\u0000\u00a8\u00a9\u00051\u0000\u0000"+
		"\u00a9\u00bd\u0003 \u0010\u000e\u00aa\u00ab\n\f\u0000\u0000\u00ab\u00ac"+
		"\u00050\u0000\u0000\u00ac\u00bd\u0003 \u0010\r\u00ad\u00ae\n\u000b\u0000"+
		"\u0000\u00ae\u00af\u0005/\u0000\u0000\u00af\u00bd\u0003 \u0010\f\u00b0"+
		"\u00b1\n\n\u0000\u0000\u00b1\u00b2\u0005-\u0000\u0000\u00b2\u00bd\u0003"+
		" \u0010\u000b\u00b3\u00b4\n\t\u0000\u0000\u00b4\u00b5\u0005.\u0000\u0000"+
		"\u00b5\u00bd\u0003 \u0010\n\u00b6\u00b7\n\b\u0000\u0000\u00b7\u00b8\u0005"+
		"*\u0000\u0000\u00b8\u00bd\u0003 \u0010\t\u00b9\u00ba\n\u0007\u0000\u0000"+
		"\u00ba\u00bb\u0005+\u0000\u0000\u00bb\u00bd\u0003 \u0010\b\u00bc\u009b"+
		"\u0001\u0000\u0000\u0000\u00bc\u009e\u0001\u0000\u0000\u0000\u00bc\u00a1"+
		"\u0001\u0000\u0000\u0000\u00bc\u00a4\u0001\u0000\u0000\u0000\u00bc\u00a7"+
		"\u0001\u0000\u0000\u0000\u00bc\u00aa\u0001\u0000\u0000\u0000\u00bc\u00ad"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b0\u0001\u0000\u0000\u0000\u00bc\u00b3"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b6\u0001\u0000\u0000\u0000\u00bc\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf!\u0001"+
		"\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\n(5Akmuy\u0099"+
		"\u00bc\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}