import { useState, useRef } from 'react';
import { Editor } from '@monaco-editor/react'; 
import './App.css'

function App() {

  const editorRef = useRef(null);
  const consolaRef = useRef(null);

  function handleEditorDidMount(editor, id) {
    if (id === "editor") {
      editorRef.current = editor;
    } else if (id === "consola") {
      consolaRef.current = editor;
    }
  }

  const cargarArchivo =() => {
    alert('Cargando archivo')
  }

  const interpretar =() => {
    alert('Interpretar')
  }

  const obtenerAST =() => {
    alert('Obtener AST')
  }

  return (
    <div className="App">
      <div className='text-center'>
        <h1>Proyecto 2 - OLC1</h1>
      </div>
      <br></br>
      <div className='text-center'>
        <div className="container">
          <div className="row">
            <input type="file" id="file" className="form-control form-control-lg" onChange={cargarArchivo} />
          </div>
          <br></br>
          <div className="row">
            <input type="button" value="Interpretar" id="btnCargar" className="form-control form-control-lg" onClick={interpretar} />
            <input type="button" value="Obtener AST" id="btnErrores" className="form-control form-control-lg" onClick={obtenerAST} />
          </div>
        </div>
      </div>
      <br></br>
      <div className='text-center style={{ height: "80%", width: "80%" }} '>
        <div className="container" >
          <div className="row">
            <div className="col">
              <p>Entrada</p>
              <Editor height="90vh" defaultLanguage="java" defaultValue="" theme="vs-dark" onMount={(editor) => handleEditorDidMount(editor, "editor")} />
            </div>
            <div className="col">
              <p>Consola</p>
              <Editor height="90vh" defaultLanguage="cpp" defaultValue="" theme="vs-dark" options={{ readOnly: true }} onMount={(editor) => handleEditorDidMount(editor, "consola")} />
            </div>
          </div>
          <div className="row">
            <div className="col">
              {/* Renderizar el grafo utilizando Graphviz */}
              {/* {grafo && <Graphviz dot={grafo} options={{ width: 400, height: 400 }} />} */}
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default App
