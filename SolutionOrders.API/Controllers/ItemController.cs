using MediatR;
using Microsoft.AspNetCore.Mvc;
using SolutionOrders.API.Features.Items.Messages.DTOs;
using SolutionOrders.API.Features.Items.Queries.GetAllItems;

namespace SolutionOrders.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ItemsController : ControllerBase
    {
        private readonly IMediator _mediator;

        public ItemsController(IMediator mediator)
        {
            _mediator = mediator;
        }

        [HttpGet]
        [ProducesResponseType(typeof(List<ItemDto>), StatusCodes.Status200OK)]
        public async Task<IActionResult> GetAll()
        {
            var query = new GetAllItemsQuery();
            var result = await _mediator.Send(query);

            return Ok(result);
        }
    }
}
