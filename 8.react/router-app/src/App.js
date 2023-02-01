import { Link, Route, Routes } from 'react-router-dom';
import './App.css';
import About from './components/About';
import Home from './components/Home';

function App() {
  return (
    <div className="App">
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
      </ul>
      <Routes>
        <Route path='/' element={<Home title="My HOME" />} />
        <Route path='/about' element={<About />} />
      </Routes>
    </div>
  );
}

export default App;
