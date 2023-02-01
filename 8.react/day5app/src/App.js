import './App.scss';
import Button from './components/Button';

function App() {
  return (
    <div className="App">
      <div className='buttons'>
        <Button size="large">확 인</Button>
        <Button>확 인</Button>
        <Button size="small">확 인</Button>
      </div>
      <div className='buttons'>
        <Button size="large" color="gray">확 인</Button>
        <Button>확 인</Button>
        <Button size="small" color="pink">확 인</Button>
      </div>
      <div className='buttons'>
        <Button size="large" color="gray" outline>확 인</Button>
        <Button outline>확 인</Button>
        <Button size="small" color="pink" outline>확 인</Button>
      </div>
    </div>
  );
}

export default App;
