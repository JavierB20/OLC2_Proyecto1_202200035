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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, NEWLINE=16, 
		INT=17, DECIMAL=18, CARACTER=19, CADENA=20, BOOL=21, ID=22, COMENTARIO_LINEA=23, 
		COMENTARIO_BLOQUE=24, IGUAL=25, DOSPUNTOS_IGUAL=26, PARENTESIS_ABRE=27, 
		PARENTESIS_CIERRA=28, CORCHETE_ABRE=29, CORCHETE_CIERRA=30, LLAVE_ABRE=31, 
		LLAVE_CIERRA=32, ASIGNACION_SUMA=33, ASIGNACION_RESTA=34, MAS=35, MENOS=36, 
		MULT=37, DIV=38, MODULO=39, Y_LOGICO=40, O_LOGICO=41, NEGACION=42, IGUAL_IGUAL=43, 
		DIFERENTE=44, MAYOR_IGUAL=45, MAYOR=46, MENOR_IGUAL=47, MENOR=48, INCREMENTO=49, 
		DECREMENTO=50;
	public static final int
		RULE_inicio = 0, RULE_listainstrucciones = 1, RULE_instruccion = 2, RULE_print = 3, 
		RULE_variables = 4, RULE_asignacion = 5, RULE_incrementoDecremento = 6, 
		RULE_instruccion_for = 7, RULE_instruccion_forcondicional = 8, RULE_tipo = 9, 
		RULE_instruccion_if = 10, RULE_instruccion_switch = 11, RULE_caso = 12, 
		RULE_caso_default = 13, RULE_expr = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "listainstrucciones", "instruccion", "print", "variables", 
			"asignacion", "incrementoDecremento", "instruccion_for", "instruccion_forcondicional", 
			"tipo", "instruccion_if", "instruccion_switch", "caso", "caso_default", 
			"expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fmt.Println'", "'var'", "'for'", "';'", "'int'", "'float64'", 
			"'string'", "'bool'", "'rune'", "'if'", "'else'", "'switch'", "'case'", 
			"':'", "'default'", null, null, null, null, null, null, null, null, null, 
			"'='", "':='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+='", "'-='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'=='", "'!='", 
			"'>='", "'>'", "'<='", "'<'", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "NEWLINE", "INT", "DECIMAL", "CARACTER", "CADENA", 
			"BOOL", "ID", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "IGUAL", "DOSPUNTOS_IGUAL", 
			"PARENTESIS_ABRE", "PARENTESIS_CIERRA", "CORCHETE_ABRE", "CORCHETE_CIERRA", 
			"LLAVE_ABRE", "LLAVE_CIERRA", "ASIGNACION_SUMA", "ASIGNACION_RESTA", 
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
			setState(30);
			listainstrucciones();
			setState(31);
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
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4199438L) != 0)) {
				{
				{
				setState(33);
				instruccion();
				}
				}
				setState(38);
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
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				print();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				variables();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				instruccion_if();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				instruccion_switch();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				incrementoDecremento();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				instruccion_for();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(46);
				instruccion_forcondicional();
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
			setState(49);
			match(T__0);
			setState(50);
			match(PARENTESIS_ABRE);
			setState(51);
			expr(0);
			setState(52);
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
			setState(54);
			match(T__1);
			setState(55);
			((DeclaracionVarContext)_localctx).identificador = match(ID);
			setState(56);
			((DeclaracionVarContext)_localctx).tipoVar = tipo();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(57);
				match(IGUAL);
				setState(58);
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
			setState(61);
			match(ID);
			setState(62);
			((AsignacionVarContext)_localctx).signo = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 25870467072L) != 0)) ) {
				((AsignacionVarContext)_localctx).signo = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(63);
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
			setState(65);
			match(ID);
			setState(66);
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
			setState(68);
			match(T__2);
			setState(69);
			expr(0);
			setState(70);
			match(LLAVE_ABRE);
			setState(71);
			listainstrucciones();
			setState(72);
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
			setState(74);
			match(T__2);
			setState(75);
			asignacion();
			setState(76);
			match(T__3);
			setState(77);
			expr(0);
			setState(78);
			match(T__3);
			setState(79);
			incrementoDecremento();
			setState(80);
			match(LLAVE_ABRE);
			setState(81);
			listainstrucciones();
			setState(82);
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
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 992L) != 0)) ) {
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
		public TerminalNode PARENTESIS_ABRE() { return getToken(AnalizadorLexicoParser.PARENTESIS_ABRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PARENTESIS_CIERRA() { return getToken(AnalizadorLexicoParser.PARENTESIS_CIERRA, 0); }
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
		enterRule(_localctx, 20, RULE_instruccion_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__9);
			setState(87);
			match(PARENTESIS_ABRE);
			setState(88);
			expr(0);
			setState(89);
			match(PARENTESIS_CIERRA);
			setState(90);
			match(LLAVE_ABRE);
			setState(91);
			listainstrucciones();
			setState(92);
			match(LLAVE_CIERRA);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(93);
				match(T__10);
				setState(99);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(94);
					instruccion_if();
					}
					break;
				case LLAVE_ABRE:
					{
					setState(95);
					match(LLAVE_ABRE);
					setState(96);
					listainstrucciones();
					setState(97);
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
		enterRule(_localctx, 22, RULE_instruccion_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__11);
			setState(104);
			expr(0);
			setState(105);
			match(LLAVE_ABRE);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(106);
				caso();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(112);
				caso_default();
				}
			}

			setState(115);
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
		enterRule(_localctx, 24, RULE_caso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__12);
			setState(118);
			expr(0);
			setState(119);
			match(T__13);
			setState(120);
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
		enterRule(_localctx, 26, RULE_caso_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__14);
			setState(123);
			match(T__13);
			setState(124);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENTESIS_ABRE:
				{
				_localctx = new ExpreParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(127);
				match(PARENTESIS_ABRE);
				setState(128);
				expr(0);
				setState(129);
				match(PARENTESIS_CIERRA);
				}
				break;
			case CORCHETE_ABRE:
				{
				_localctx = new ExpreCorchetesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(CORCHETE_ABRE);
				setState(132);
				expr(0);
				setState(133);
				match(CORCHETE_CIERRA);
				}
				break;
			case MENOS:
				{
				_localctx = new OperadorNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				((OperadorNegativoContext)_localctx).operador = match(MENOS);
				setState(136);
				((OperadorNegativoContext)_localctx).right = expr(19);
				}
				break;
			case NEGACION:
				{
				_localctx = new OperadorNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				((OperadorNegacionContext)_localctx).operador = match(NEGACION);
				setState(138);
				((OperadorNegacionContext)_localctx).right = expr(18);
				}
				break;
			case INT:
				{
				_localctx = new IntExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(INT);
				}
				break;
			case DECIMAL:
				{
				_localctx = new DecimalExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(DECIMAL);
				}
				break;
			case CARACTER:
				{
				_localctx = new CaracterExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(CARACTER);
				}
				break;
			case BOOL:
				{
				_localctx = new BoleanExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(BOOL);
				}
				break;
			case CADENA:
				{
				_localctx = new CadenaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(CADENA);
				}
				break;
			case ID:
				{
				_localctx = new IdExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionYdivisionContext(new ExprContext(_parentctx, _parentState));
						((MultiplicacionYdivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(148);
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
						setState(149);
						((MultiplicacionYdivisionContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ModuloContext(new ExprContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(151);
						((ModuloContext)_localctx).operador = match(MODULO);
						setState(152);
						((ModuloContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new SumaYrestaContext(new ExprContext(_parentctx, _parentState));
						((SumaYrestaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(154);
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
						setState(155);
						((SumaYrestaContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(157);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR);
						setState(158);
						((OperadorRelacionalContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(160);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR_IGUAL);
						setState(161);
						((OperadorRelacionalContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(163);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR);
						setState(164);
						((OperadorRelacionalContext)_localctx).right = expr(13);
						}
						break;
					case 7:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(166);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR_IGUAL);
						setState(167);
						((OperadorRelacionalContext)_localctx).right = expr(12);
						}
						break;
					case 8:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(169);
						((OperadorRelacionalContext)_localctx).operador = match(IGUAL_IGUAL);
						setState(170);
						((OperadorRelacionalContext)_localctx).right = expr(11);
						}
						break;
					case 9:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(172);
						((OperadorRelacionalContext)_localctx).operador = match(DIFERENTE);
						setState(173);
						((OperadorRelacionalContext)_localctx).right = expr(10);
						}
						break;
					case 10:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(174);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(175);
						((OperadorLogicoContext)_localctx).operador = match(Y_LOGICO);
						setState(176);
						((OperadorLogicoContext)_localctx).right = expr(9);
						}
						break;
					case 11:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(178);
						((OperadorLogicoContext)_localctx).operador = match(O_LOGICO);
						setState(179);
						((OperadorLogicoContext)_localctx).right = expr(8);
						}
						break;
					}
					} 
				}
				setState(184);
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
		case 14:
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
		"\u0004\u00012\u00ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001#\b\u0001\n\u0001\f\u0001&\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004<\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nd\b\n\u0003\nf\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bl\b\u000b\n\u000b"+
		"\f\u000bo\t\u000b\u0001\u000b\u0003\u000br\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0092\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00b5\b\u000e\n\u000e\f\u000e\u00b8\t\u000e\u0001\u000e\u0000"+
		"\u0001\u001c\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u0000\u0005\u0002\u0000\u0019\u001a!\"\u0001"+
		"\u000012\u0001\u0000\u0005\t\u0001\u0000%&\u0001\u0000#$\u00cb\u0000\u001e"+
		"\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004/\u0001\u0000"+
		"\u0000\u0000\u00061\u0001\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000"+
		"\n=\u0001\u0000\u0000\u0000\fA\u0001\u0000\u0000\u0000\u000eD\u0001\u0000"+
		"\u0000\u0000\u0010J\u0001\u0000\u0000\u0000\u0012T\u0001\u0000\u0000\u0000"+
		"\u0014V\u0001\u0000\u0000\u0000\u0016g\u0001\u0000\u0000\u0000\u0018u"+
		"\u0001\u0000\u0000\u0000\u001az\u0001\u0000\u0000\u0000\u001c\u0091\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000\u001f \u0005\u0000"+
		"\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!#\u0003\u0004\u0002\u0000"+
		"\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000$%\u0001\u0000\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000\'0\u0003\u0006\u0003\u0000(0\u0003\b\u0004\u0000)0"+
		"\u0003\n\u0005\u0000*0\u0003\u0014\n\u0000+0\u0003\u0016\u000b\u0000,"+
		"0\u0003\f\u0006\u0000-0\u0003\u000e\u0007\u0000.0\u0003\u0010\b\u0000"+
		"/\'\u0001\u0000\u0000\u0000/(\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000"+
		"\u0000/*\u0001\u0000\u0000\u0000/+\u0001\u0000\u0000\u0000/,\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u00000\u0005"+
		"\u0001\u0000\u0000\u000012\u0005\u0001\u0000\u000023\u0005\u001b\u0000"+
		"\u000034\u0003\u001c\u000e\u000045\u0005\u001c\u0000\u00005\u0007\u0001"+
		"\u0000\u0000\u000067\u0005\u0002\u0000\u000078\u0005\u0016\u0000\u0000"+
		"8;\u0003\u0012\t\u00009:\u0005\u0019\u0000\u0000:<\u0003\u001c\u000e\u0000"+
		";9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\t\u0001\u0000\u0000"+
		"\u0000=>\u0005\u0016\u0000\u0000>?\u0007\u0000\u0000\u0000?@\u0003\u001c"+
		"\u000e\u0000@\u000b\u0001\u0000\u0000\u0000AB\u0005\u0016\u0000\u0000"+
		"BC\u0007\u0001\u0000\u0000C\r\u0001\u0000\u0000\u0000DE\u0005\u0003\u0000"+
		"\u0000EF\u0003\u001c\u000e\u0000FG\u0005\u001f\u0000\u0000GH\u0003\u0002"+
		"\u0001\u0000HI\u0005 \u0000\u0000I\u000f\u0001\u0000\u0000\u0000JK\u0005"+
		"\u0003\u0000\u0000KL\u0003\n\u0005\u0000LM\u0005\u0004\u0000\u0000MN\u0003"+
		"\u001c\u000e\u0000NO\u0005\u0004\u0000\u0000OP\u0003\f\u0006\u0000PQ\u0005"+
		"\u001f\u0000\u0000QR\u0003\u0002\u0001\u0000RS\u0005 \u0000\u0000S\u0011"+
		"\u0001\u0000\u0000\u0000TU\u0007\u0002\u0000\u0000U\u0013\u0001\u0000"+
		"\u0000\u0000VW\u0005\n\u0000\u0000WX\u0005\u001b\u0000\u0000XY\u0003\u001c"+
		"\u000e\u0000YZ\u0005\u001c\u0000\u0000Z[\u0005\u001f\u0000\u0000[\\\u0003"+
		"\u0002\u0001\u0000\\e\u0005 \u0000\u0000]c\u0005\u000b\u0000\u0000^d\u0003"+
		"\u0014\n\u0000_`\u0005\u001f\u0000\u0000`a\u0003\u0002\u0001\u0000ab\u0005"+
		" \u0000\u0000bd\u0001\u0000\u0000\u0000c^\u0001\u0000\u0000\u0000c_\u0001"+
		"\u0000\u0000\u0000df\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000f\u0015\u0001\u0000\u0000\u0000gh\u0005\f\u0000"+
		"\u0000hi\u0003\u001c\u000e\u0000im\u0005\u001f\u0000\u0000jl\u0003\u0018"+
		"\f\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000pr\u0003\u001a\r\u0000qp\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005 \u0000\u0000t\u0017"+
		"\u0001\u0000\u0000\u0000uv\u0005\r\u0000\u0000vw\u0003\u001c\u000e\u0000"+
		"wx\u0005\u000e\u0000\u0000xy\u0003\u0002\u0001\u0000y\u0019\u0001\u0000"+
		"\u0000\u0000z{\u0005\u000f\u0000\u0000{|\u0005\u000e\u0000\u0000|}\u0003"+
		"\u0002\u0001\u0000}\u001b\u0001\u0000\u0000\u0000~\u007f\u0006\u000e\uffff"+
		"\uffff\u0000\u007f\u0080\u0005\u001b\u0000\u0000\u0080\u0081\u0003\u001c"+
		"\u000e\u0000\u0081\u0082\u0005\u001c\u0000\u0000\u0082\u0092\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u001d\u0000\u0000\u0084\u0085\u0003\u001c"+
		"\u000e\u0000\u0085\u0086\u0005\u001e\u0000\u0000\u0086\u0092\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005$\u0000\u0000\u0088\u0092\u0003\u001c\u000e"+
		"\u0013\u0089\u008a\u0005*\u0000\u0000\u008a\u0092\u0003\u001c\u000e\u0012"+
		"\u008b\u0092\u0005\u0011\u0000\u0000\u008c\u0092\u0005\u0012\u0000\u0000"+
		"\u008d\u0092\u0005\u0013\u0000\u0000\u008e\u0092\u0005\u0015\u0000\u0000"+
		"\u008f\u0092\u0005\u0014\u0000\u0000\u0090\u0092\u0005\u0016\u0000\u0000"+
		"\u0091~\u0001\u0000\u0000\u0000\u0091\u0083\u0001\u0000\u0000\u0000\u0091"+
		"\u0087\u0001\u0000\u0000\u0000\u0091\u0089\u0001\u0000\u0000\u0000\u0091"+
		"\u008b\u0001\u0000\u0000\u0000\u0091\u008c\u0001\u0000\u0000\u0000\u0091"+
		"\u008d\u0001\u0000\u0000\u0000\u0091\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u00b6\u0001\u0000\u0000\u0000\u0093\u0094\n\u0011\u0000\u0000\u0094\u0095"+
		"\u0007\u0003\u0000\u0000\u0095\u00b5\u0003\u001c\u000e\u0012\u0096\u0097"+
		"\n\u0010\u0000\u0000\u0097\u0098\u0005\'\u0000\u0000\u0098\u00b5\u0003"+
		"\u001c\u000e\u0011\u0099\u009a\n\u000f\u0000\u0000\u009a\u009b\u0007\u0004"+
		"\u0000\u0000\u009b\u00b5\u0003\u001c\u000e\u0010\u009c\u009d\n\u000e\u0000"+
		"\u0000\u009d\u009e\u00050\u0000\u0000\u009e\u00b5\u0003\u001c\u000e\u000f"+
		"\u009f\u00a0\n\r\u0000\u0000\u00a0\u00a1\u0005/\u0000\u0000\u00a1\u00b5"+
		"\u0003\u001c\u000e\u000e\u00a2\u00a3\n\f\u0000\u0000\u00a3\u00a4\u0005"+
		".\u0000\u0000\u00a4\u00b5\u0003\u001c\u000e\r\u00a5\u00a6\n\u000b\u0000"+
		"\u0000\u00a6\u00a7\u0005-\u0000\u0000\u00a7\u00b5\u0003\u001c\u000e\f"+
		"\u00a8\u00a9\n\n\u0000\u0000\u00a9\u00aa\u0005+\u0000\u0000\u00aa\u00b5"+
		"\u0003\u001c\u000e\u000b\u00ab\u00ac\n\t\u0000\u0000\u00ac\u00ad\u0005"+
		",\u0000\u0000\u00ad\u00b5\u0003\u001c\u000e\n\u00ae\u00af\n\b\u0000\u0000"+
		"\u00af\u00b0\u0005(\u0000\u0000\u00b0\u00b5\u0003\u001c\u000e\t\u00b1"+
		"\u00b2\n\u0007\u0000\u0000\u00b2\u00b3\u0005)\u0000\u0000\u00b3\u00b5"+
		"\u0003\u001c\u000e\b\u00b4\u0093\u0001\u0000\u0000\u0000\u00b4\u0096\u0001"+
		"\u0000\u0000\u0000\u00b4\u0099\u0001\u0000\u0000\u0000\u00b4\u009c\u0001"+
		"\u0000\u0000\u0000\u00b4\u009f\u0001\u0000\u0000\u0000\u00b4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00b4\u00a5\u0001\u0000\u0000\u0000\u00b4\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000\u00b4\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b7\u001d\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\n$/;cemq\u0091\u00b4\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}