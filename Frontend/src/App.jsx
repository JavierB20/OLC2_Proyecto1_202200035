import { useRef } from 'react';
import { Editor } from '@monaco-editor/react';
import './App.css';

function App() {
  const editorRef = useRef(null);
  const consolaRef = useRef(null);

  async function sendCode(dataEditor) {
    try {
      const response = await fetch('http://localhost:5239/Compilador', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dataEditor),
      });
  
      if (!response.ok) {
        throw new Error('Error en la petición');
      }
  
      const result = await response.json();
      const output = Array.isArray(result.result) 
        ? result.result.join("\n") 
        : result.result;  

      const errors = Array.isArray(result.errors) 
      ? result.errors.map(err => 
          `${err.descripcion} en línea ${err.linea}, columna ${err.columna}: ${err.tipo}`
        ).join("\n") 
      : result.errors;

      if (consolaRef.current) {
        consolaRef.current.setValue(output + "\n\n" + errors);
      }
    } catch (error) {
      console.log(error);
      consolaRef.current.setValue(`Error: ${error.message}`); 
    }
  }

  function handleEditorDidMount(editor, id) {
    if (id === 'editor') {
      editorRef.current = editor;
    } else if (id === 'consola') {
      consolaRef.current = editor;
    }
  }

  const cargarArchivo = () => {
    alert('Cargando archivo');
  };

  const interpretar = () => {
    const code = editorRef.current.getValue(); 
    sendCode({ Code: code });
  };

  const obtenerAST = () => {
    alert('Obtener AST');
  };

  return (
    <div className="container-fluid" style={{ height: '100vh', width: '100vw' }}>
      {/* Navbar */}
      <nav className="navbar navbar-dark bg-dark d-flex justify-content-center p-3">
        <h4 className="text-light me-3">Proyecto 2 - OLC1</h4>
        <input type="file" id="file" className="btn btn-outline-light me-3" onChange={cargarArchivo} />
        <button className="btn btn-primary me-2" onClick={interpretar}>Interpretar</button>
        <button className="btn btn-secondary" onClick={obtenerAST}>Obtener AST</button>
      </nav>

      {/* Contenedor de editores */}
      <div className="row m-0" style={{ height: 'calc(100vh - 56px)' }}>
        <div className="col-6 p-2">
          <p className="text-center text-light bg-dark p-2">Entrada</p>
          <Editor
            height="90vh"
            defaultLanguage="java"
            defaultValue=""
            theme="vs-dark"
            onMount={(editor) => handleEditorDidMount(editor, 'editor')}
          />
        </div>
        <div className="col-6 p-2">
          <p className="text-center text-light bg-dark p-2">Consola</p>
          <Editor
            height="90vh"
            defaultLanguage="cpp"
            defaultValue=""
            theme="vs-dark"
            options={{ readOnly: true }}
            onMount={(editor) => handleEditorDidMount(editor, 'consola')}
          />
        </div>
      </div>
    </div>
  );
}

export default App;
