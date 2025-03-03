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
		T__9=10, T__10=11, T__11=12, T__12=13, NEWLINE=14, INT=15, DECIMAL=16, 
		CARACTER=17, CADENA=18, BOOL=19, ID=20, COMENTARIO_LINEA=21, COMENTARIO_BLOQUE=22, 
		IGUAL=23, DOSPUNTOS_IGUAL=24, PARENTESIS_ABRE=25, PARENTESIS_CIERRA=26, 
		CORCHETE_ABRE=27, CORCHETE_CIERRA=28, LLAVE_ABRE=29, LLAVE_CIERRA=30, 
		ASIGNACION_SUMA=31, ASIGNACION_RESTA=32, MAS=33, MENOS=34, MULT=35, DIV=36, 
		MODULO=37, Y_LOGICO=38, O_LOGICO=39, NEGACION=40, IGUAL_IGUAL=41, DIFERENTE=42, 
		MAYOR_IGUAL=43, MAYOR=44, MENOR_IGUAL=45, MENOR=46, INCREMENTO=47, DECREMENTO=48;
	public static final int
		RULE_inicio = 0, RULE_listainstrucciones = 1, RULE_instruccion = 2, RULE_print = 3, 
		RULE_variables = 4, RULE_asignacion = 5, RULE_incrementoDecremento = 6, 
		RULE_tipo = 7, RULE_instruccion_if = 8, RULE_instruccion_switch = 9, RULE_caso = 10, 
		RULE_caso_default = 11, RULE_expr = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "listainstrucciones", "instruccion", "print", "variables", 
			"asignacion", "incrementoDecremento", "tipo", "instruccion_if", "instruccion_switch", 
			"caso", "caso_default", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fmt.Println'", "'var'", "'int'", "'float64'", "'string'", "'bool'", 
			"'rune'", "'if'", "'else'", "'switch'", "'case'", "':'", "'default'", 
			null, null, null, null, null, null, null, null, null, "'='", "':='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'+='", "'-='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'=='", "'!='", "'>='", "'>'", 
			"'<='", "'<'", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NEWLINE", "INT", "DECIMAL", "CARACTER", "CADENA", "BOOL", 
			"ID", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "IGUAL", "DOSPUNTOS_IGUAL", 
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
			setState(26);
			listainstrucciones();
			setState(27);
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
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1049862L) != 0)) {
				{
				{
				setState(29);
				instruccion();
				}
				}
				setState(34);
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
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				print();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				variables();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				instruccion_if();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				instruccion_switch();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				incrementoDecremento();
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
			setState(43);
			match(T__0);
			setState(44);
			match(PARENTESIS_ABRE);
			setState(45);
			expr(0);
			setState(46);
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
			setState(48);
			match(T__1);
			setState(49);
			((DeclaracionVarContext)_localctx).identificador = match(ID);
			setState(50);
			((DeclaracionVarContext)_localctx).tipoVar = tipo();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(51);
				match(IGUAL);
				setState(52);
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
			setState(55);
			match(ID);
			setState(56);
			((AsignacionVarContext)_localctx).signo = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6467616768L) != 0)) ) {
				((AsignacionVarContext)_localctx).signo = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(57);
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
			setState(59);
			match(ID);
			setState(60);
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
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 248L) != 0)) ) {
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
		enterRule(_localctx, 16, RULE_instruccion_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__7);
			setState(65);
			match(PARENTESIS_ABRE);
			setState(66);
			expr(0);
			setState(67);
			match(PARENTESIS_CIERRA);
			setState(68);
			match(LLAVE_ABRE);
			setState(69);
			listainstrucciones();
			setState(70);
			match(LLAVE_CIERRA);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(71);
				match(T__8);
				setState(77);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(72);
					instruccion_if();
					}
					break;
				case LLAVE_ABRE:
					{
					setState(73);
					match(LLAVE_ABRE);
					setState(74);
					listainstrucciones();
					setState(75);
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
		enterRule(_localctx, 18, RULE_instruccion_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__9);
			setState(82);
			expr(0);
			setState(83);
			match(LLAVE_ABRE);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(84);
				caso();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(90);
				caso_default();
				}
			}

			setState(93);
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
		enterRule(_localctx, 20, RULE_caso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__10);
			setState(96);
			expr(0);
			setState(97);
			match(T__11);
			setState(98);
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
		enterRule(_localctx, 22, RULE_caso_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__12);
			setState(101);
			match(T__11);
			setState(102);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENTESIS_ABRE:
				{
				_localctx = new ExpreParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(105);
				match(PARENTESIS_ABRE);
				setState(106);
				expr(0);
				setState(107);
				match(PARENTESIS_CIERRA);
				}
				break;
			case CORCHETE_ABRE:
				{
				_localctx = new ExpreCorchetesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(CORCHETE_ABRE);
				setState(110);
				expr(0);
				setState(111);
				match(CORCHETE_CIERRA);
				}
				break;
			case MENOS:
				{
				_localctx = new OperadorNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				((OperadorNegativoContext)_localctx).operador = match(MENOS);
				setState(114);
				((OperadorNegativoContext)_localctx).right = expr(19);
				}
				break;
			case NEGACION:
				{
				_localctx = new OperadorNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				((OperadorNegacionContext)_localctx).operador = match(NEGACION);
				setState(116);
				((OperadorNegacionContext)_localctx).right = expr(18);
				}
				break;
			case INT:
				{
				_localctx = new IntExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(INT);
				}
				break;
			case DECIMAL:
				{
				_localctx = new DecimalExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(DECIMAL);
				}
				break;
			case CARACTER:
				{
				_localctx = new CaracterExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(CARACTER);
				}
				break;
			case BOOL:
				{
				_localctx = new BoleanExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(BOOL);
				}
				break;
			case CADENA:
				{
				_localctx = new CadenaExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(CADENA);
				}
				break;
			case ID:
				{
				_localctx = new IdExpresionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionYdivisionContext(new ExprContext(_parentctx, _parentState));
						((MultiplicacionYdivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(126);
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
						setState(127);
						((MultiplicacionYdivisionContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ModuloContext(new ExprContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(129);
						((ModuloContext)_localctx).operador = match(MODULO);
						setState(130);
						((ModuloContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new SumaYrestaContext(new ExprContext(_parentctx, _parentState));
						((SumaYrestaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(132);
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
						setState(133);
						((SumaYrestaContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(135);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR);
						setState(136);
						((OperadorRelacionalContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(138);
						((OperadorRelacionalContext)_localctx).operador = match(MENOR_IGUAL);
						setState(139);
						((OperadorRelacionalContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(141);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR);
						setState(142);
						((OperadorRelacionalContext)_localctx).right = expr(13);
						}
						break;
					case 7:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(144);
						((OperadorRelacionalContext)_localctx).operador = match(MAYOR_IGUAL);
						setState(145);
						((OperadorRelacionalContext)_localctx).right = expr(12);
						}
						break;
					case 8:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(147);
						((OperadorRelacionalContext)_localctx).operador = match(IGUAL_IGUAL);
						setState(148);
						((OperadorRelacionalContext)_localctx).right = expr(11);
						}
						break;
					case 9:
						{
						_localctx = new OperadorRelacionalContext(new ExprContext(_parentctx, _parentState));
						((OperadorRelacionalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(150);
						((OperadorRelacionalContext)_localctx).operador = match(DIFERENTE);
						setState(151);
						((OperadorRelacionalContext)_localctx).right = expr(10);
						}
						break;
					case 10:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(153);
						((OperadorLogicoContext)_localctx).operador = match(Y_LOGICO);
						setState(154);
						((OperadorLogicoContext)_localctx).right = expr(9);
						}
						break;
					case 11:
						{
						_localctx = new OperadorLogicoContext(new ExprContext(_parentctx, _parentState));
						((OperadorLogicoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(156);
						((OperadorLogicoContext)_localctx).operador = match(O_LOGICO);
						setState(157);
						((OperadorLogicoContext)_localctx).right = expr(8);
						}
						break;
					}
					} 
				}
				setState(162);
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
		case 12:
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
		"\u0004\u00010\u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001"+
		"\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002*\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u00046\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\bN\b\b\u0003\bP\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tV\b\t\n\t"+
		"\f\tY\t\t\u0001\t\u0003\t\\\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f|\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u009f\b\f\n\f\f\f\u00a2\t\f\u0001\f\u0000\u0001\u0018\r\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0005\u0002"+
		"\u0000\u0017\u0018\u001f \u0001\u0000/0\u0001\u0000\u0003\u0007\u0001"+
		"\u0000#$\u0001\u0000!\"\u00b5\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		" \u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006+\u0001"+
		"\u0000\u0000\u0000\b0\u0001\u0000\u0000\u0000\n7\u0001\u0000\u0000\u0000"+
		"\f;\u0001\u0000\u0000\u0000\u000e>\u0001\u0000\u0000\u0000\u0010@\u0001"+
		"\u0000\u0000\u0000\u0012Q\u0001\u0000\u0000\u0000\u0014_\u0001\u0000\u0000"+
		"\u0000\u0016d\u0001\u0000\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005\u0000\u0000\u0001\u001c"+
		"\u0001\u0001\u0000\u0000\u0000\u001d\u001f\u0003\u0004\u0002\u0000\u001e"+
		"\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0003\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000#*\u0003\u0006\u0003\u0000$*\u0003"+
		"\b\u0004\u0000%*\u0003\n\u0005\u0000&*\u0003\u0010\b\u0000\'*\u0003\u0012"+
		"\t\u0000(*\u0003\f\u0006\u0000)#\u0001\u0000\u0000\u0000)$\u0001\u0000"+
		"\u0000\u0000)%\u0001\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000)\'\u0001"+
		"\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*\u0005\u0001\u0000\u0000"+
		"\u0000+,\u0005\u0001\u0000\u0000,-\u0005\u0019\u0000\u0000-.\u0003\u0018"+
		"\f\u0000./\u0005\u001a\u0000\u0000/\u0007\u0001\u0000\u0000\u000001\u0005"+
		"\u0002\u0000\u000012\u0005\u0014\u0000\u000025\u0003\u000e\u0007\u0000"+
		"34\u0005\u0017\u0000\u000046\u0003\u0018\f\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u00006\t\u0001\u0000\u0000\u000078\u0005\u0014\u0000"+
		"\u000089\u0007\u0000\u0000\u00009:\u0003\u0018\f\u0000:\u000b\u0001\u0000"+
		"\u0000\u0000;<\u0005\u0014\u0000\u0000<=\u0007\u0001\u0000\u0000=\r\u0001"+
		"\u0000\u0000\u0000>?\u0007\u0002\u0000\u0000?\u000f\u0001\u0000\u0000"+
		"\u0000@A\u0005\b\u0000\u0000AB\u0005\u0019\u0000\u0000BC\u0003\u0018\f"+
		"\u0000CD\u0005\u001a\u0000\u0000DE\u0005\u001d\u0000\u0000EF\u0003\u0002"+
		"\u0001\u0000FO\u0005\u001e\u0000\u0000GM\u0005\t\u0000\u0000HN\u0003\u0010"+
		"\b\u0000IJ\u0005\u001d\u0000\u0000JK\u0003\u0002\u0001\u0000KL\u0005\u001e"+
		"\u0000\u0000LN\u0001\u0000\u0000\u0000MH\u0001\u0000\u0000\u0000MI\u0001"+
		"\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000P\u0011\u0001\u0000\u0000\u0000QR\u0005\n\u0000"+
		"\u0000RS\u0003\u0018\f\u0000SW\u0005\u001d\u0000\u0000TV\u0003\u0014\n"+
		"\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000Z\\\u0003\u0016\u000b\u0000[Z\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u001e\u0000"+
		"\u0000^\u0013\u0001\u0000\u0000\u0000_`\u0005\u000b\u0000\u0000`a\u0003"+
		"\u0018\f\u0000ab\u0005\f\u0000\u0000bc\u0003\u0002\u0001\u0000c\u0015"+
		"\u0001\u0000\u0000\u0000de\u0005\r\u0000\u0000ef\u0005\f\u0000\u0000f"+
		"g\u0003\u0002\u0001\u0000g\u0017\u0001\u0000\u0000\u0000hi\u0006\f\uffff"+
		"\uffff\u0000ij\u0005\u0019\u0000\u0000jk\u0003\u0018\f\u0000kl\u0005\u001a"+
		"\u0000\u0000l|\u0001\u0000\u0000\u0000mn\u0005\u001b\u0000\u0000no\u0003"+
		"\u0018\f\u0000op\u0005\u001c\u0000\u0000p|\u0001\u0000\u0000\u0000qr\u0005"+
		"\"\u0000\u0000r|\u0003\u0018\f\u0013st\u0005(\u0000\u0000t|\u0003\u0018"+
		"\f\u0012u|\u0005\u000f\u0000\u0000v|\u0005\u0010\u0000\u0000w|\u0005\u0011"+
		"\u0000\u0000x|\u0005\u0013\u0000\u0000y|\u0005\u0012\u0000\u0000z|\u0005"+
		"\u0014\u0000\u0000{h\u0001\u0000\u0000\u0000{m\u0001\u0000\u0000\u0000"+
		"{q\u0001\u0000\u0000\u0000{s\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000"+
		"\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u00a0"+
		"\u0001\u0000\u0000\u0000}~\n\u0011\u0000\u0000~\u007f\u0007\u0003\u0000"+
		"\u0000\u007f\u009f\u0003\u0018\f\u0012\u0080\u0081\n\u0010\u0000\u0000"+
		"\u0081\u0082\u0005%\u0000\u0000\u0082\u009f\u0003\u0018\f\u0011\u0083"+
		"\u0084\n\u000f\u0000\u0000\u0084\u0085\u0007\u0004\u0000\u0000\u0085\u009f"+
		"\u0003\u0018\f\u0010\u0086\u0087\n\u000e\u0000\u0000\u0087\u0088\u0005"+
		".\u0000\u0000\u0088\u009f\u0003\u0018\f\u000f\u0089\u008a\n\r\u0000\u0000"+
		"\u008a\u008b\u0005-\u0000\u0000\u008b\u009f\u0003\u0018\f\u000e\u008c"+
		"\u008d\n\f\u0000\u0000\u008d\u008e\u0005,\u0000\u0000\u008e\u009f\u0003"+
		"\u0018\f\r\u008f\u0090\n\u000b\u0000\u0000\u0090\u0091\u0005+\u0000\u0000"+
		"\u0091\u009f\u0003\u0018\f\f\u0092\u0093\n\n\u0000\u0000\u0093\u0094\u0005"+
		")\u0000\u0000\u0094\u009f\u0003\u0018\f\u000b\u0095\u0096\n\t\u0000\u0000"+
		"\u0096\u0097\u0005*\u0000\u0000\u0097\u009f\u0003\u0018\f\n\u0098\u0099"+
		"\n\b\u0000\u0000\u0099\u009a\u0005&\u0000\u0000\u009a\u009f\u0003\u0018"+
		"\f\t\u009b\u009c\n\u0007\u0000\u0000\u009c\u009d\u0005\'\u0000\u0000\u009d"+
		"\u009f\u0003\u0018\f\b\u009e}\u0001\u0000\u0000\u0000\u009e\u0080\u0001"+
		"\u0000\u0000\u0000\u009e\u0083\u0001\u0000\u0000\u0000\u009e\u0086\u0001"+
		"\u0000\u0000\u0000\u009e\u0089\u0001\u0000\u0000\u0000\u009e\u008c\u0001"+
		"\u0000\u0000\u0000\u009e\u008f\u0001\u0000\u0000\u0000\u009e\u0092\u0001"+
		"\u0000\u0000\u0000\u009e\u0095\u0001\u0000\u0000\u0000\u009e\u0098\u0001"+
		"\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009f\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a1\u0019\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\n )5MOW[{\u009e\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}