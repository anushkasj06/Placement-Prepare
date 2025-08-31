import { useState } from "react";

function Calculator({ title }: { title: string }) {
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    const [result, setResult] = useState<number | null>(null);

    return (
        <div style={{ width: '300px', textAlign: 'center', padding: '20px', border: '1px solid #ccc', borderRadius: '5px', margin: '10px', transition: 'background-color 0.3s' }} onMouseEnter={(e) => e.currentTarget.style.backgroundColor = '#f0f0f0'} onMouseLeave={(e) => e.currentTarget.style.backgroundColor = 'white'}>
            <h2>{title}</h2>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
            <input type="number" style={{ padding: '5px', borderRadius: '4px', border: '1px solid #ccc', transition: 'border-color 0.3s' }} placeholder="Enter first number" onChange={(e) => setNum1(Number(e.target.value))} />
            <input type="number" style={{ padding: '5px', borderRadius: '4px', border: '1px solid #ccc', transition: 'border-color 0.3s' }} placeholder="Enter second number" onChange={(e) => setNum2(Number(e.target.value))} />
            <button style={{ width:'200px', padding: '5px', borderRadius: '4px', border: '1px solid #ccc', backgroundColor: 'lightblue',  transition: 'background-color 0.3s' }} onMouseEnter={(e) => e.currentTarget.style.backgroundColor = '#add8e6'} onMouseLeave={(e) => e.currentTarget.style.backgroundColor = 'lightblue'} onClick={() => setResult(num1 + num2)}>Add</button>
            <button style={{ width:'200px', padding: '5px', borderRadius: '4px', border: '1px solid #ccc', backgroundColor: 'lightcoral',  transition: 'background-color 0.3s' }} onMouseEnter={(e) => e.currentTarget.style.backgroundColor = '#f08080'} onMouseLeave={(e) => e.currentTarget.style.backgroundColor = 'lightcoral'} onClick={() => setResult(num1 - num2)}>Subtract</button>
            <button style={{ width:'200px', padding: '5px', borderRadius: '4px', border: '1px solid #ccc', backgroundColor: 'lightgreen',  transition: 'background-color 0.3s' }} onMouseEnter={(e) => e.currentTarget.style.backgroundColor = '#90ee90'} onMouseLeave={(e) => e.currentTarget.style.backgroundColor = 'lightgreen'} onClick={() => setResult(num1 * num2)}>Multiply</button>
            <button style={{ width:'200px', padding: '5px', borderRadius: '4px', border: '1px solid #ccc', backgroundColor: 'lightyellow',  transition: 'background-color 0.3s' }} onMouseEnter={(e) => e.currentTarget.style.backgroundColor = '#ffffe0'} onMouseLeave={(e) => e.currentTarget.style.backgroundColor = 'lightyellow'} onClick={() => setResult(num1 / num2)}>Divide</button>
            <div className="Result">Result: {result !== null ? result : "No result"}</div>
            </div>
        </div>
    );
}

export default Calculator;
