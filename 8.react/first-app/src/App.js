import logo from './logo.svg';
import './App.css';

function App() {
  let name;
  const myStyle = {backgroundColor : 'red',color : 'yellow'};
  const myH2style = {backgroundColor:'pink', border:'1px solid black'}

  return (
    <div className='App'>
      <h1 style={myStyle}>처음해보는 리액트</h1>
      <h2 style={myH2style}>{name||'Guest'} </h2>
      <input type='text' name='a'/>
    </div>
  );
}

export default App;
