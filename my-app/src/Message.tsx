    function Message() {
    return (
        <>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span className="navbar-toggler-icon"></span>
  </button>
  <a className="navbar-brand" href="#">Navbar</a>

  <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
      <li className="nav-item active">
        <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Link</a>
      </li>
      <li className="nav-item">
        <a className="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form className="form-inline my-2 my-lg-0">
      <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
      <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
   </nav>
    
    <h1 style={{ color: 'red' }}>Hello World by Message</h1>
    <br /><br />
    <ul className="list-group shadow-lg p-3 mb-5 bg-body rounded">
    <li className="list-group-item active p-3 mb-2 bg-primary text-white">Cras justo odio</li>
    <li className="list-group-item">Dapibus ac facilisis in</li>
    <li className="list-group-item">Morbi leo risus</li>
    <li className="list-group-item">Porta ac consectetur ac</li>
    <li className="list-group-item">Vestibulum at eros</li>
    </ul>
    <br /><br />

        <button type="button" className="btn btn-primary">Primary</button>
        <br />
        <br />
        <button type="button" className="btn btn-secondary">Secondary</button>
        <br />
        <br />
        <button type="button" className="btn btn-success">Success</button>

        <br /><br />
        <div className="card" style={{ width: '18rem' }}>
            <div className="card-body">
                <h5 className="card-title">Card title</h5>
                <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
        </div>

        <br /><br />
        <div className="card" style={{ width: '18rem' }}>
            <div className="card-body">
                <h5 className="card-title">Card title</h5>
                <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
        </div>

        <footer className="bg-dark text-white text-center py-3">
            <p>© 2023 My App. All rights reserved.</p>
        </footer>
    </>
    );

}

    export default Message;