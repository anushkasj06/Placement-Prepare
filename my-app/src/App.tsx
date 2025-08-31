import React, { useState } from 'react'
// import Message from './Message.tsx';
// import ExtraMessage from './Extramessage.tsx';
import "bootstrap/dist/css/bootstrap.css";
import Calculator from './Calculator.tsx';

function App() {

  const [steps, setSteps] = useState(0);
  const [counter, setCounter] = useState(0);

  return (
    <>
      {/* <Message />
      {/* <ExtraMessage /> 
      <ExtraMessage /> */}

      {/* <div className="counter" style={{ margin: '5px', padding: '5px' , color: 'blue'}}>counter: {counter}</div>
      <button className="increment" onClick={() => setCounter(counter + steps)} style={{ margin: '5px', padding: '5px', color: 'green', backgroundColor: 'lightgreen' }}>Increment</button>
      <button className="decrement" onClick={() => setCounter(counter - steps)} style={{ margin: '5px', padding: '5px', color: 'red', backgroundColor: 'lightcoral' }}>Decrement</button>
      <div className="currentstep" style={{ margin: '5px', padding: '5px' }}>Current Step: {steps}</div>
      <input type="number" name='steps' placeholder="steps"  onChange={(e) => setSteps(Number(e.target.value))} style={{ margin: '5px', padding: '5px' }} value={steps}></input>
      <button className="increamentstep" onClick={() => setSteps(steps + 1)} style={{ margin: '5px', padding: '5px', color: 'green', backgroundColor: 'lightgreen' }}>+1</button>
      <button className="decreamentstep" onClick={() => setSteps(steps - 1)} style={{ margin: '5px', padding: '5px', color: 'red', backgroundColor: 'lightcoral' }}>-1</button> */}

      < Calculator  title="My Calculator"/>

    </>


  )
}

export default App;
